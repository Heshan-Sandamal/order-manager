package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.web.api.Order;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by vibodhab on 2/8/18.
 */

public interface OrderService {

    public Order setOrder(Order order);
    void setOrders(List<Order> orders);
    public Order getOrder(String id);
    public ArrayList<Order> getUserOrders(String id);

}
