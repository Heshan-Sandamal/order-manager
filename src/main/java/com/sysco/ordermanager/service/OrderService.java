package com.sysco.ordermanager.service;

import com.sysco.ordermanager.web.api.Order;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by vibodhab on 2/8/18.
 */

public interface OrderService {

    void setOrders(List<Order> orders);
    Order cancelOrder(Long id);
    Order getOrder(Long id);
    List<Order> getOrders();
    Order setOrder(Order order);
    List<Order> getUserOrders(Long id);

}
