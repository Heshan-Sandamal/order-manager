package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.RestaurantData;
import com.sysco.ordermanager.web.api.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantConverter {

    @Autowired
    private UserConverter userConverter;

    public Restaurant convertRestaurantDataToRestaurant(RestaurantData restaurantData){
        return new Restaurant(
                restaurantData.getId(),
                restaurantData.getAddress(),
                userConverter.convertUserDataToUserDTO(restaurantData.getUserData())
        );
    }

    public RestaurantData convertRestaurantToRestaurantData(Restaurant restaurant){
        return new RestaurantData(
                restaurant.getId(),
                restaurant.getAddress(),
                userConverter.convertUserToUserData(restaurant.getUserDTO())
        );
    }

    public List<Restaurant> convertRestaurantListToRestaurantDataList(List<RestaurantData> restaurantDataList){
        return restaurantDataList.stream()
                .map(this::convertRestaurantDataToRestaurant)
                .collect(Collectors.toList());
    }

    public List<RestaurantData> convertRestaurantDataListToRestaurantList(List<Restaurant> restaurantList){
        return restaurantList.stream()
                .map(this::convertRestaurantToRestaurantData)
                .collect(Collectors.toList());
    }
}
