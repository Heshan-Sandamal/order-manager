package com.sysco.ordermanager.service;

import com.sysco.ordermanager.web.api.Restaurant;

public interface RestaurantService {

    public Restaurant getRestaurant(String id);
    public Restaurant addRestaurant(Restaurant restaurant);
}
