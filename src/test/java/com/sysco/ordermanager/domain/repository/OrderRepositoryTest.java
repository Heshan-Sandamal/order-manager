
package com.sysco.ordermanager.domain.repository;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.domain.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = {"test"})
@WebAppConfiguration
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    public OrderRepository orderRepository;

    @Test
    public void getOrdersByType(){
        List<OrderData> orderDataList = orderRepository.findByType("type1");
        orderDataList.forEach(orderData -> System.out.println(orderData.getId() + " " + orderData.getType()));
    }
}

