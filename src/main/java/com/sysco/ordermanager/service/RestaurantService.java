package com.sysco.ordermanager.service;

import com.sysco.ordermanager.web.api.Restaurant;

public interface RestaurantService {

    public Restaurant getRestaurant(long id);
    public Restaurant addRestaurant(Restaurant restaurant);
    public Restaurant updateRestaurant(Restaurant restaurant);
}
