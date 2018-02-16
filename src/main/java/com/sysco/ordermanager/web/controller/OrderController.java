package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.service.OrderService;
import com.sysco.ordermanager.web.api.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import java.util.List;


/**
 * Created by vibodhab on 2/8/18.
 */
@RestController
@RequestMapping(path = "api/order")
public class OrderController {

    @Autowired
    OrderService orderService;



    @GetMapping("/{order_id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long order_id){
        Order order = orderService.getOrder(order_id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Order> setOrder(@RequestBody Order order){
        Order newOrder = orderService.setOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PostMapping("/multiple")
    public ResponseEntity<List<Order>> update(@RequestBody List<Order> orders) {
        orderService.setOrders(orders);
        return new ResponseEntity<>(orders, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>>   getOrders(){
        List<Order> orders = orderService.getOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<Order>>  getUserOrders(@PathVariable Long user_id){
        List<Order> orders = orderService.getUserOrders(user_id);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/cancel/{order_id}")
    public ResponseEntity<Order> cancelOrder(@PathVariable Long order_id){
        Order order = orderService.cancelOrder(order_id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
