package com.sysco.ordermanager.service;

import com.sysco.ordermanager.aspect.anotation.ValidateGetRequestId;
import com.sysco.ordermanager.domain.repository.RestaurantRepository;
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

    @Override
    @ValidateGetRequestId
    public Restaurant getRestaurant(String id) {
        return restaurantConverter.convertRestaurantDataToRestaurant(restaurantRepository.getOne(id));
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantConverter.convertRestaurantDataToRestaurant(
                restaurantRepository.save(restaurantConverter.convertRestaurantToRestaurantData(restaurant))
        );
    }
}
