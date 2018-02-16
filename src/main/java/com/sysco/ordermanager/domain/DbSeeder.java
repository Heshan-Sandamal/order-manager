package com.sysco.ordermanager.domain;

import com.sysco.ordermanager.domain.repository.OrderRepository;
import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.service.ItemService;
import com.sysco.ordermanager.service.OrderService;
import com.sysco.ordermanager.service.converter.ItemConverter;
import com.sysco.ordermanager.service.converter.UserConverter;
import com.sysco.ordermanager.util.enums.OrderStatus;
import com.sysco.ordermanager.web.api.Item;
import com.sysco.ordermanager.web.api.Order;
import com.sysco.ordermanager.web.api.OrderItem;
import com.sysco.ordermanager.web.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by vibodhab on 2/8/18.
 */
@Component
public class DbSeeder implements CommandLineRunner {
    @Autowired
    ItemService itemService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    OrderService orderService;


    @Autowired
    private UserRepository userRepository;


    @Autowired
    ItemConverter itemConverter;

    @Autowired
    UserConverter userConverter;

    @Override
    public void run(String... strings) throws Exception {

//        OrderData orderData = new OrderData("1", "type1",3);

//        orderRepository.deleteAll();
//        orderRepository.save(orderData);

        User user = new User("Shanika", "123");
        user=userConverter.convertUserDataToUser(userRepository.save(userConverter.convertUserToUserData(user)));

        Item item = new Item(1,"test-item", "abc", "xxx", 100);
        item = itemService.addItem(item);


        Order order = new Order("aaa", user, OrderStatus.CREATED);

        OrderItem oid = new OrderItem(order, item, 22.3);

        final Set<OrderItem> orderItems = new HashSet<>();
        orderItems.add(oid);

        order.setOrderItems(orderItems);

        orderService.setOrder(order);


//        userRepository.deleteAll();
//        orderRepository.deleteAll();

//        OrderData orderData = new OrderData("1", "type1", 3, userData);
//        orderRepository.save(orderData);
//        orderRepository.save(orderData);
//        itemService.addItem(new Item("test-item", "abc", "xxx", 100));

    }
}
