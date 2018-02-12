package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.service.RestaurantService;
import com.sysco.ordermanager.web.api.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(path = "/{id}")
    public Restaurant getUser(@PathVariable String id){
        return restaurantService.getRestaurant(id);
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant){
        return new ResponseEntity<Restaurant>(
                restaurantService.addRestaurant(restaurant),
                HttpStatus.CREATED
        );
    }
}
