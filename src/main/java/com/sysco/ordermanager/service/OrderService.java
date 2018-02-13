package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.web.api.Order;

import java.util.List;

/**
 * Created by vibodhab on 2/8/18.
 */

public interface OrderService {

    Order getOrder(String id);
    void setOrder(Order order);
    void setOrders(List<Order> orders);

}
