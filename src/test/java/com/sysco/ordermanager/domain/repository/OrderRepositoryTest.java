package com.sysco.ordermanager.domain.repository;

import com.sysco.ordermanager.domain.model.*;
import com.sysco.ordermanager.util.enums.OrderStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class) // need for assert functions
@ActiveProfiles(profiles = {"test"})
@DataJpaTest
public class OrderRepositoryTest {

    private final Long ORDER_ID=2L;
    private final String TYPE="Test-type";
    private final double ORDER_ITEM_AMOUNT=34;

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;



    @Test
    public void setOrderTest(){

        UserData userData=new UserData();
        userData=entityManager.persist(userData);

        ItemData itemData=new ItemData();
        itemData=entityManager.persist(itemData);

        entityManager.flush();

        OrderData orderData=new OrderData(TYPE, userData, OrderStatus.CREATED);

        OrderData orderDataReturn=new OrderData(TYPE, userData, OrderStatus.CREATED);
        orderDataReturn.setId(ORDER_ID);

        final Set<OrderItemData> orderItemDataSet = new HashSet<>();
        orderItemDataSet.add(new OrderItemData(new OrderItemId(orderData,itemData),ORDER_ITEM_AMOUNT));

        orderData.setOrderItems(orderItemDataSet);

        final OrderData persist = orderRepository.save(orderData);
        final OrderData searchedOrderDataOb = entityManager.find(OrderData.class,persist.getId());

        Assert.assertEquals(persist,searchedOrderDataOb);

    }

    @Test
    public void getOneTest() {

        UserData userData = new UserData(
                "vibodha",
                "123"
        );

        OrderData orderData = new OrderData(
                "coke",
                userData,
                OrderStatus.CREATED
        );

        ItemData itemData = new ItemData(
                "Pepsi",
                "Drink",
                "Pepsico",
                12
        );

        OrderItemData orderItemData = new OrderItemData(
                new OrderItemId(orderData, itemData),
                10
        );

        final Set<OrderItemData> orderItems = new HashSet<>();
        orderItems.add(orderItemData);
        orderData.setOrderItems(orderItems);

        entityManager.persist(itemData);
        entityManager.persist(userData);
        final OrderData persistOrder = entityManager.persist(orderData);
        entityManager.persist(orderItemData);
        entityManager.flush();

        OrderData orderFound = orderRepository.getOne(persistOrder.getId());
        assertThat(orderFound).isEqualToComparingFieldByFieldRecursively(orderData);
    }

    @Test
    public void findByUserDataIdTest() {
        UserData userData1 = new UserData("vibodha", "123");
        UserData userData2 = new UserData("chamath", "1234");

        OrderData orderData1 = new OrderData("coke1", userData1, OrderStatus.CREATED);
        OrderData orderData2 = new OrderData("coke2", userData1, OrderStatus.CREATED);
        OrderData orderData3 = new OrderData("coke3", userData2, OrderStatus.CREATED);

        ItemData itemData1 = new ItemData("Pepsi", "Drink", "Pepsico", 12);
        ItemData itemData2 = new ItemData("Pepsi", "Drink", "Pepsico", 12);
        ItemData itemData3 = new ItemData("Pepsi", "Drink", "Pepsico", 12);

        OrderItemData orderItemData1 = new OrderItemData(new OrderItemId(orderData1, itemData1), 10);
        OrderItemData orderItemData2 = new OrderItemData(new OrderItemId(orderData1, itemData2), 10);
        OrderItemData orderItemData3 = new OrderItemData(new OrderItemId(orderData2, itemData2), 10);
        OrderItemData orderItemData4 = new OrderItemData(new OrderItemId(orderData3, itemData3), 10);

        final Set<OrderItemData> orderItems1 = new HashSet<>();
        orderItems1.add(orderItemData1);
        orderItems1.add(orderItemData2);
        orderData1.setOrderItems(orderItems1);

        final Set<OrderItemData> orderItems2 = new HashSet<>();
        orderItems2.add(orderItemData3);
        orderData2.setOrderItems(orderItems2);

        final Set<OrderItemData> orderItems3 = new HashSet<>();
        orderItems3.add(orderItemData4);
        orderData3.setOrderItems(orderItems3);

        entityManager.persist(itemData1);
        entityManager.persist(itemData2);
        entityManager.persist(itemData3);

        entityManager.persist(userData1);
        entityManager.persist(userData2);
        final OrderData persistOrder1 = entityManager.persist(orderData1);
        final OrderData persistOrder2 = entityManager.persist(orderData2);
        final OrderData persistOrder3 = entityManager.persist(orderData3);
        entityManager.persist(orderItemData1);
        entityManager.persist(orderItemData2);
        entityManager.persist(orderItemData3);
        entityManager.persist(orderItemData4);
        entityManager.flush();

        Long user1Id = userData1.getId();
        List<OrderData> userOrders = orderRepository.findByUserDataId(user1Id);
        assertThat(userOrders.size()).isEqualTo(2); // 2 orders
        System.out.println("userOrders.size() :" + userOrders.size());
        for (OrderData order : userOrders) {
            assertThat(order.getUserData().getId()).isEqualTo(user1Id);
        }
    }

    @Test
    public void getOrdersByType() {
        List<OrderData> orderDataList = orderRepository.findByType("type1");
        orderDataList.forEach(orderData -> System.out.println(orderData.getId() + " " + orderData.getType()));
    }
}