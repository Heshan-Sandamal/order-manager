package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.ItemData;
import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.model.OrderItemData;
import com.sysco.ordermanager.domain.model.OrderItemId;
import com.sysco.ordermanager.web.api.Item;
import com.sysco.ordermanager.web.api.Order;
import com.sysco.ordermanager.web.api.OrderItem;
import com.sysco.ordermanager.web.api.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = {"test"})
@WebAppConfiguration
@SpringBootTest
public class OrderItemConverterTest {

    @Autowired
    OrderItemConverter orderItemConverter;

    @Autowired
    OrderConverter orderConverter;

    @Autowired
    ItemConverter itemConverter;

    @Test
    public void convertOrderItemToOrderItemData() {

    }

    @Test
    public void convertOrderItemDataToOrderItem() {
    }

    @Test
    public void convertOrderItemToOrderItemData1() {
        Order order=new Order(22L,"INCO",3,new User("ds","dsf","212"),new HashSet<>());

        Item item=new Item();
        item.setId(33);

        final OrderData orderData = new OrderData();
        orderData.setId(22L);


        final ItemData itemData = new ItemData();
        itemData.setId(33);

        OrderItem orderItem=new OrderItem(order,item,33.2);

        OrderItemData convertedOrderItemData = orderItemConverter.convertOrderItemToOrderItemData(orderItem, orderData);

        OrderItemData expectedOrderItemData = new OrderItemData(new OrderItemId(orderData,itemData),33.2);
        assertEquals(convertedOrderItemData,expectedOrderItemData);
    }

    @Test
    public void convertOrderItemDataToOrderItem1() {
    }

    @Test
    public void convertOrderItemDataListToOrderItemList() {
    }

    @Test
    public void convertOrderItemListToOrderItemDataList() {
    }
}