package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.ItemData;
import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.model.OrderItemData;
import com.sysco.ordermanager.web.api.Item;
import com.sysco.ordermanager.web.api.Order;
import com.sysco.ordermanager.web.api.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemConverter {

    @Autowired
    ItemConverter itemConverter;

    @Autowired
    OrderConverter orderConverter;

    public OrderItemData convertOrderItemToOrderItemData(OrderItem orderItem){
        final ItemData itemData = itemConverter.convertItemToItemData(orderItem.getItem());
        final OrderData orderData = orderConverter.convertOrderToOrderData(orderItem.getOrder());
        return new OrderItemData(orderData,itemData,orderItem.getAmount());

    }

    public OrderItem convertOrderItemDataToOrderItem(OrderItemData orderItemData){
        final Item itemData = itemConverter.convertItemDataToItem(orderItemData.getItem());
        final Order orderData = orderConverter.convertOrderDataToOrder(orderItemData.getOrder());
        return new OrderItem(orderData,itemData,orderItemData.getAmount());

    }


}
