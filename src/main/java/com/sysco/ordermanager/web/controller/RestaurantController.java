package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.service.RestaurantService;
import com.sysco.ordermanager.web.api.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(path = "/{id}")
    public Restaurant getRestaurant(@PathVariable long id){
        return restaurantService.getRestaurant(id);
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody Restaurant restaurant){
        return new ResponseEntity<Restaurant>(
                restaurantService.addRestaurant(restaurant),
                HttpStatus.CREATED
        );
    }

}
