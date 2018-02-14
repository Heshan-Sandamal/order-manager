package com.sysco.ordermanager.domain;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.model.OrderItemData;
import com.sysco.ordermanager.domain.model.OrderItemId;
import com.sysco.ordermanager.domain.repository.ItemRepository;
import com.sysco.ordermanager.domain.repository.OrderRepository;
import com.sysco.ordermanager.service.ItemService;
import com.sysco.ordermanager.service.OrderService;
import com.sysco.ordermanager.service.converter.ItemConverter;
import com.sysco.ordermanager.web.api.Item;
import com.sysco.ordermanager.web.api.Order;
import com.sysco.ordermanager.web.api.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vibodhab on 2/8/18.
 */
@Component
public class DbSeeder implements CommandLineRunner{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    ItemService itemService;

    @Autowired
    ItemConverter itemConverter;

    @Override
    public void run(String... strings) throws Exception {

//        OrderData orderData = new OrderData("1", "type1",3);

//        orderRepository.deleteAll();
//        orderRepository.save(orderData);
        Item item = new Item("test-item", "abc", "xxx", 100);
        item = itemService.addItem(item);


        Order order=new Order("23",2);

        OrderItem oid=new OrderItem(order,item,22.3);

        final Set<OrderItem> orderItems = new HashSet<>();
        orderItems.add(oid);

        order.setOrderItems(orderItems);

        orderService.setOrder(order);






    }
}
