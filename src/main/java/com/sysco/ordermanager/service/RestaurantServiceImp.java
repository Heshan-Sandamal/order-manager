package com.sysco.ordermanager.service;

import com.sysco.ordermanager.aspect.Exception.UserNotFoundException;
import com.sysco.ordermanager.aspect.anotation.CheckRestaurantExist;
import com.sysco.ordermanager.aspect.anotation.ValidateGetRequestId;
import com.sysco.ordermanager.aspect.anotation.ValidateUserNotFound;
import com.sysco.ordermanager.domain.model.RestaurantData;
import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.domain.repository.RestaurantRepository;
import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.service.converter.RestaurantConverter;
import com.sysco.ordermanager.web.api.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    public Restaurant getRestaurant(long id) {
        return restaurantConverter.convertRestaurantDataToRestaurant(restaurantRepository.getOne(id));
    }

    @Override
    @ValidateUserNotFound
    @Transactional
    public Restaurant addRestaurant(Restaurant restaurant) {
        RestaurantData restaurantData = restaurantConverter.convertRestaurantToRestaurantData(restaurant);
        return restaurantConverter.convertRestaurantDataToRestaurant(restaurantRepository.save(restaurantData));
    }

    @Override
    @CheckRestaurantExist
    @Transactional
    public Restaurant updateRestaurant(Restaurant restaurant){
        RestaurantData restaurantData = restaurantConverter.convertRestaurantToRestaurantData(restaurant);
        return restaurantConverter.convertRestaurantDataToRestaurant(restaurantRepository.save(restaurantData));
    }
}
