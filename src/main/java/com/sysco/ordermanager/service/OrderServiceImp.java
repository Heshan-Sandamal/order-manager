package com.sysco.ordermanager.service;
import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.repository.OrderRepository;
import com.sysco.ordermanager.service.converter.OrderConverter;
import com.sysco.ordermanager.web.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vibodhab on 2/8/18.
 */
@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderConverter orderConverter;

    @Override
    public Order getOrder(String id) {
        return orderConverter.convertOrderDataToOrder(orderRepository.getOne(id));
    }

    @Override
    public void setOrder(Order order) {
        orderRepository.save(orderConverter.convertOrderToOrderData(order));
    }

    @Override
    public void setOrders(List<Order> orders) {

        List<OrderData> ordersDataList = new ArrayList<>();
        orders.forEach(order ->
                ordersDataList.add(orderConverter.convertOrderToOrderData(order)));
        orderRepository.save(ordersDataList);

    }

}
