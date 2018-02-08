package com.sysco.ordermanager.domain;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by vibodhab on 2/8/18.
 */
@Component
public class DbSeeder implements CommandLineRunner{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... strings) throws Exception {
        OrderData orderData = new OrderData("1", "type1");

//        orderRepository.deleteAll();
        orderRepository.save(orderData);
    }
}
