package com.sysco.ordermanager.aspect.Exception;

import com.sysco.ordermanager.web.api.ErrorResponse;

public class RestaurantNotFoundException extends ApiException{

    private static RestaurantNotFoundException restaurantNotFoundException= new RestaurantNotFoundException();

    public RestaurantNotFoundException() {
        super(new ErrorResponse("E001", 404, "Restaurant not found", ""));
    }

    public static RestaurantNotFoundException getInstance(){
        return restaurantNotFoundException;
    }
}
