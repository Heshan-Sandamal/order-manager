package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.web.api.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vibodhab on 2/8/18.
 */
@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @GetMapping("/{id}")
    public Order getUser(@PathVariable String id){
        return new Order("1", "new");
    }
}
