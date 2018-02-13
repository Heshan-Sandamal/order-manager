package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.web.api.Order;

import java.util.ArrayList;

/**
 * Created by vibodhab on 2/8/18.
 */

public interface OrderService {

    public Order getOrder(String id);
    public Order setOrder(Order order);
    public ArrayList<Order> getUserOrders(String id);

}
