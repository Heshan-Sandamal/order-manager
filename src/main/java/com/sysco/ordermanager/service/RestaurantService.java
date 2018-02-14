package com.sysco.ordermanager.service;

import com.sysco.ordermanager.web.api.Restaurant;

public interface RestaurantService {

    Restaurant getRestaurant(String id);
    Restaurant addRestaurant(Restaurant restaurant);
}
