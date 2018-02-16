package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.ItemData;
import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.model.OrderItemData;
import com.sysco.ordermanager.domain.model.OrderItemId;
import com.sysco.ordermanager.web.api.Item;
import com.sysco.ordermanager.web.api.Order;
import com.sysco.ordermanager.web.api.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OrderItemConverter {

    @Autowired
    ItemConverter itemConverter;

    @Autowired
    OrderConverter orderConverter;

    public OrderItemData convertOrderItemToOrderItemData(OrderItem orderItem){
        final ItemData itemData = itemConverter.convertItemToItemData(orderItem.getItem());
        final OrderData orderData = orderConverter.convertOrderToOrderData(orderItem.getOrder());
        return new OrderItemData(new OrderItemId(orderData,itemData),orderItem.getAmount());

    }

    public OrderItem convertOrderItemDataToOrderItem(OrderItemData orderItemData){
        final Item itemData = itemConverter.convertItemDataToItem(orderItemData.getOrderItemId().getItem());
        final Order orderData = orderConverter.convertOrderDataToOrder(orderItemData.getOrderItemId().getOrder());
        return new OrderItem(orderData,itemData,orderItemData.getAmount());

    }

    public OrderItemData convertOrderItemToOrderItemData(OrderItem orderItem,OrderData orderData){
        final ItemData itemData = itemConverter.convertItemToItemDataWithId(orderItem.getItem());
        return new OrderItemData(new OrderItemId(orderData,itemData),orderItem.getAmount());
    }


    public OrderItem convertOrderItemDataToOrderItem(OrderItemData orderItemData,Order order){
        final Item item = itemConverter.convertItemDataToItem(orderItemData.getOrderItemId().getItem());
        return new OrderItem(order,item,orderItemData.getAmount());

    }

    public Set<OrderItem> convertOrderItemDataListToOrderItemList(Set<OrderItemData> orderItemDataSet, Order order){
        Set<OrderItem> orderItemSet=new HashSet<>();
        for (OrderItemData orderItemData: orderItemDataSet) {
            orderItemSet.add(this.convertOrderItemDataToOrderItem(orderItemData,order));
        }
        return orderItemSet;
    }


    public Set<OrderItemData> convertOrderItemListToOrderItemDataList(Set<OrderItem> orderItems, OrderData orderData) {
        Set<OrderItemData> orderItemDataSet=new HashSet<>();
        for (OrderItem orderItem:orderItems) {
            orderItemDataSet.add(this.convertOrderItemToOrderItemData(orderItem,orderData));
        }
        return orderItemDataSet;
    }
}
