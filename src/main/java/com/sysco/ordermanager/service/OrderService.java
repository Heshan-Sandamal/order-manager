package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.web.api.Order;

import java.util.ArrayList;

/**
 * Created by vibodhab on 2/8/18.
 */

public interface OrderService {

    Order getOrder(String id);
    Order setOrder(Order order);
    ArrayList<Order> getUserOrders(String id);

}
