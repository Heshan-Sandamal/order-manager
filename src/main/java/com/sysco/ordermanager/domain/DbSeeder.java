package com.sysco.ordermanager.domain;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.repository.ItemRepository;
import com.sysco.ordermanager.domain.repository.OrderRepository;
import com.sysco.ordermanager.service.ItemService;
import com.sysco.ordermanager.web.api.Item;
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

    @Autowired
    ItemService itemService;

    @Override
    public void run(String... strings) throws Exception {
        OrderData orderData = new OrderData("1", "type1",3);

//        orderRepository.deleteAll();
        orderRepository.save(orderData);
        itemService.addItem(new Item("test-item","abc","xxx",100));



    }
}
