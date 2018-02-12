package com.sysco.ordermanager.service;
import com.sysco.ordermanager.aspect.anotation.ValidateGetRequestId;
import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.repository.OrderRepository;
import com.sysco.ordermanager.service.converter.OrderConverter;
import com.sysco.ordermanager.web.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public OrderData setOrder(Order order) {
        return orderRepository.save(orderConverter.convertOrderToOrderData(order));
    }

}
