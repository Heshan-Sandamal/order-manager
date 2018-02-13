package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.service.OrderService;
import com.sysco.ordermanager.web.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vibodhab on 2/8/18.
 */
@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public Order getUser(@PathVariable String id){
        return orderService.getOrder(id);
    }

    @PostMapping("/")
    public ResponseEntity<Order> setOrder(@RequestBody Order order){
        orderService.setOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
