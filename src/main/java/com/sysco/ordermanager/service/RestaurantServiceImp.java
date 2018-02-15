package com.sysco.ordermanager.service;

import com.sysco.ordermanager.aspect.anotation.ValidateGetRequestId;
import com.sysco.ordermanager.domain.model.RestaurantData;
import com.sysco.ordermanager.domain.repository.RestaurantRepository;
import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.service.converter.RestaurantConverter;
import com.sysco.ordermanager.web.api.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImp implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantConverter restaurantConverter;

    @Autowired
    private UserRepository userRepository;

    @Override
    @ValidateGetRequestId
    public Restaurant getRestaurant(String id) {
        return restaurantConverter.convertRestaurantDataToRestaurant(restaurantRepository.getOne(id));
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {

        RestaurantData restaurantData = restaurantConverter.convertRestaurantToRestaurantData(restaurant);

        return restaurantConverter.convertRestaurantDataToRestaurant(restaurantRepository.save(restaurantData));
    }
}
