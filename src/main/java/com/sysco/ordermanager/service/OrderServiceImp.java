package com.sysco.ordermanager.service;
import com.sysco.ordermanager.aspect.anotation.ValidateGetRequestId;
import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.util.enums.OrderStatus;
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
    public Order getOrder(Long id) {
        return orderConverter.convertOrderDataToOrder(orderRepository.getOne(id));
    }

    @Override
    public List<Order> getOrders() {
        List<OrderData> orderData = orderRepository.findAll();
        ArrayList<Order> orders = new ArrayList<>();
        for (OrderData anOrderData : orderData) {
            Order tempOrder = orderConverter.convertOrderDataToOrder(anOrderData);
            orders.add(tempOrder);
        }
        return orders;
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
    public List<Order> getUserOrders(Long id) {
        List<OrderData> userOrderData = orderRepository.findByUserDataId(id);
        ArrayList<Order> userOrders = new ArrayList<>();
        for (OrderData anUserOrderData : userOrderData) {
            Order tempOrder = orderConverter.convertOrderDataToOrder(anUserOrderData);
            userOrders.add(tempOrder);
        }
        return userOrders;
    }

    @Override
    public Order cancelOrder(Long id) {
        OrderData orderData = orderRepository.findOne(id);
        if(orderData.getOrderStatus() != OrderStatus.DISPATCHED){
            orderData.setOrderStatus(OrderStatus.CANCELLED);
        }
        return orderConverter.convertOrderDataToOrder(orderRepository.save(orderData));
    }


}
