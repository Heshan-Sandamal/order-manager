package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vibodhab on 2/8/18.
 */
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderData getOrder(String id) {
        OrderData orderData = orderRepository.getOne(id);
        return orderData;
    }
}
