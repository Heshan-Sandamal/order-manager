package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.service.OrderService;
import com.sysco.ordermanager.web.api.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Created by vibodhab on 2/8/18.
 */
@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    public Order getUser(@PathVariable String id, Principal principal){
        System.out.println("____________________________");
        System.out.println(principal.getName());
        System.out.println("____________________________");
        return orderService.getOrder(id);
    }

    @PostMapping("/")
    public ResponseEntity<Order> setOrder(@RequestBody Order order){
        orderService.setOrder(order);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
