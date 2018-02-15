package com.sysco.ordermanager.service;
import com.sysco.ordermanager.aspect.anotation.ValidateGetRequestId;
import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.model.Status;
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
    @ValidateGetRequestId
    public Order getOrder(String id) {
        return orderConverter.convertOrderDataToOrder(orderRepository.getOne(id));
    }

    @Override
    public Order setOrder(Order order) {
        OrderData orderData = orderConverter.convertOrderToOrderData(order);
        return orderConverter.convertOrderDataToOrder(orderRepository.save(orderData));
    }

    @Override
    public void setOrders(List<Order> orders) {

        List<OrderData> ordersDataList = new ArrayList<>();
        orders.forEach(order ->
                ordersDataList.add(orderConverter.convertOrderToOrderData(order)));
        orderRepository.save(ordersDataList);
    }

    @Override
    public ArrayList<Order> getUserOrders(String id) {
        ArrayList<OrderData> userOrderData = orderRepository.findByUserData(id);
        ArrayList<Order> userOrders = new ArrayList<>();
        for (int i = 0; i < userOrderData.size(); i++){
            Order tempOrder = orderConverter.convertOrderDataToOrder(userOrderData.get(i));
            userOrders.add(tempOrder);
        }
        return userOrders;
    }

    @Override
    public Order cancelOrder(Long id) {
        OrderData orderData = orderRepository.findById(id);
        if(orderData.getStatus() != Status.DISPATCHED){
            orderData.setStatus(Status.CANCELLED);
        }
        return orderConverter.convertOrderDataToOrder(orderRepository.save(orderData));
    }


}
