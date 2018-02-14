package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.RestaurantData;
import com.sysco.ordermanager.web.api.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantConverter {

    @Autowired
    private UserConverter userConverter;

    public Restaurant convertRestaurantDataToRestaurant(RestaurantData restaurantData){
        return new Restaurant(
                restaurantData.getId(),
                restaurantData.getAddress(),
                userConverter.convertUserDataToUser(restaurantData.getUserData())
        );
    }

    public RestaurantData convertRestaurantToRestaurantData(Restaurant restaurant){
        return new RestaurantData(
                restaurant.getId(),
                restaurant.getAddress(),
                userConverter.convertUserToUserData(restaurant.getUserDTO())
        );
    }
}
