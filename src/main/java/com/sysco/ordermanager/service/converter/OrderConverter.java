package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.web.api.Order;
import org.springframework.stereotype.Service;

/**
 * Created by vibodhab on 2/9/18.
 */
@Service
public class OrderConverter {
    public Order convertOrderDataToOrder(OrderData orderData){
        return new Order(
                orderData.getId(),
                orderData.getType(),
                orderData.getQuantity()
        );
    }

    public OrderData convertOrderToOrderData(Order order){
        return new OrderData(
                order.getId(),
                order.getType(),
                order.getQuantity()
        );
    }
}
