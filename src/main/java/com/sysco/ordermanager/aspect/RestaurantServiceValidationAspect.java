package com.sysco.ordermanager.aspect;

import com.sysco.ordermanager.aspect.Exception.RestaurantNotFoundException;
import com.sysco.ordermanager.aspect.Exception.UserNotFoundException;
import com.sysco.ordermanager.domain.model.RestaurantData;
import com.sysco.ordermanager.domain.repository.RestaurantRepository;
import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.web.api.Restaurant;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Aspect
@Component
public class RestaurantServiceValidationAspect {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Before("execution(@com.sysco.ordermanager.aspect.anotation.ValidateUserNotFound * *(..))")
    public void validateUser(JoinPoint joinPoint){
        Restaurant restaurant = (Restaurant) joinPoint.getArgs()[0];
        if(restaurant.getUser()==null){
            throw UserNotFoundException.getInstance();
        }
        try {
            userRepository.getOne(restaurant.getUser().getId()).getId();
        }
        catch (EntityNotFoundException e){
            throw UserNotFoundException.getInstance();
        }
    }

    @Before("execution(@com.sysco.ordermanager.aspect.anotation.CheckRestaurantExist * *(..))")
    public void checkRestaurant(JoinPoint joinPoint){
        Restaurant restaurant = (Restaurant) joinPoint.getArgs()[0];
        RestaurantData restaurantData = restaurantRepository.getOne(restaurant.getId());
        try {
            restaurantData.getId();
        } catch (EntityNotFoundException e){
            throw RestaurantNotFoundException.getInstance();
        }
    }
}
