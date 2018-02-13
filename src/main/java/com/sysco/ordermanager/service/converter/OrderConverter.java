package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.web.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vibodhab on 2/9/18.
 */
@Service
public class OrderConverter {
    @Autowired
    private UserConverter userConverter;

    public Order convertOrderDataToOrder(OrderData orderData){
        return new Order(
                orderData.getId(),
                orderData.getType(),
                orderData.getQuantity(),
                userConverter.convertUserDataToUser(orderData.getUserData())
        );
    }

    public OrderData convertOrderToOrderData(Order order){
        return new OrderData(
                order.getId(),
                order.getType(),
                order.getQuantity(),
                userConverter.convertUserToUserData(order.getUser())
        );
    }
}
