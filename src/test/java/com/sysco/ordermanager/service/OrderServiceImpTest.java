package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.model.*;
import com.sysco.ordermanager.domain.repository.OrderRepository;
import com.sysco.ordermanager.service.converter.OrderConverter;
import com.sysco.ordermanager.util.enums.OrderStatus;
import com.sysco.ordermanager.web.api.Item;
import com.sysco.ordermanager.web.api.Order;
import com.sysco.ordermanager.web.api.OrderItem;
import com.sysco.ordermanager.web.api.UserDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = {"test"})
@WebAppConfiguration
@SpringBootTest
public class OrderServiceImpTest {

    @MockBean
    OrderRepository orderRepository;

    @MockBean
    OrderConverter orderConverter;

    @Autowired
    OrderService orderService;

    private Order order=null;

    private final Long USER_ID=2L;
    private final Long ORDER_ID=2L;
    private final Integer ITEM_ID=2;
    private final String TYPE="Test-type";
    private double ORDER_ITEM_AMOUNT=34;

    @Test
    public void setOrder() {
        final Order orderReturned = orderService.setOrder(this.order);
        assertEquals(order.getType(),orderReturned.getType());
        assertEquals(order.getOrderStatus(),orderReturned.getOrderStatus());
        assertNotNull(orderReturned.getId());
    }


    @Before
    public void setup() {

        UserDTO user = new UserDTO();
        user.setId(USER_ID);

        this.order=new Order(TYPE, user, OrderStatus.CREATED);

        UserData userData=new UserData();
        userData.setId(USER_ID);

        Item item = new Item();
        item.setId(ITEM_ID);

        ItemData itemData=new ItemData();
        itemData.setId(ITEM_ID);

        OrderItem oid = new OrderItem(order, item, ORDER_ITEM_AMOUNT);
        final Set<OrderItem> orderItems = new HashSet<>();
        order.setOrderItems(orderItems);
        orderItems.add(oid);

        Order orderReturn=new Order(ORDER_ID,TYPE, user, OrderStatus.CREATED);
        OrderItem oidReturn = new OrderItem(orderReturn, item, ORDER_ITEM_AMOUNT);
        final Set<OrderItem> orderItemsReturn = new HashSet<>();
        orderReturn.setOrderItems(orderItemsReturn);
        orderItemsReturn.add(oidReturn);


        OrderData orderData=new OrderData(TYPE, userData, OrderStatus.CREATED);

        OrderData orderDataReturn=new OrderData(TYPE, userData, OrderStatus.CREATED);
        orderDataReturn.setId(ORDER_ID);

        final Set<OrderItemData> orderItemDataSet = new HashSet<>();
        orderItemDataSet.add(new OrderItemData(new OrderItemId(orderData,itemData),ORDER_ITEM_AMOUNT));
        orderData.setOrderItems(orderItemDataSet);

        Mockito.when(orderRepository.save(orderData)).thenReturn(orderDataReturn);

        Mockito.when(orderConverter.convertOrderDataToOrder(orderDataReturn)).thenReturn(orderReturn);
        Mockito.when(orderConverter.convertOrderToOrderData(order)).thenReturn(orderData);



    }

}