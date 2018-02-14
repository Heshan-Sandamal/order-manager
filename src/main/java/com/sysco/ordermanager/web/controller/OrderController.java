package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.service.OrderService;
import com.sysco.ordermanager.web.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by vibodhab on 2/8/18.
 */
@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @GetMapping("/{order_id}")
    public Order getOrder(@PathVariable String order_id){
        return orderService.getOrder(order_id);
    }

    @PostMapping("/")
    public ResponseEntity<Order> setOrder(@RequestBody Order order){
        orderService.setOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PostMapping("/multiple")
    public ResponseEntity<List<Order>> update(@RequestBody List<Order> orders) {
        orderService.setOrders(orders);
        return new ResponseEntity<>(orders, HttpStatus.CREATED);
    }

    @GetMapping("/user/{user_id}")
    public ArrayList<Order> getUserOrders(@PathVariable String user_id){
        return orderService.getUserOrders(user_id);
    }
}
