package com.sysco.ordermanager.domain;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.domain.repository.OrderRepository;
import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.service.ItemService;
import com.sysco.ordermanager.web.api.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    private UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {
//        userRepository.deleteAll();
//        orderRepository.deleteAll();
//        UserData userData = new UserData("1", "Shanika", "123");
//        userRepository.save(userData);
//        OrderData orderData = new OrderData("1", "type1", 3, userData);
//        orderRepository.save(orderData);
//        orderRepository.save(orderData);
//        itemService.addItem(new Item("test-item", "abc", "xxx", 100));

    }
}
