package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.RestaurantData;
import com.sysco.ordermanager.web.api.Restaurant;
import org.springframework.stereotype.Service;

@Service
public class RestaurantConverter {

    public Restaurant convertRestaurantDataToRestaurant(RestaurantData restaurantData){
        return new Restaurant(
                restaurantData.getId(),
                restaurantData.getAddress(),
                restaurantData.getOwner()
        );
    }

    public RestaurantData convertRestaurantToRestaurantData(Restaurant restaurant){
        return new RestaurantData(
                restaurant.getId(),
                restaurant.getAddress(),
                restaurant.getOwner()
        );
    }
}
