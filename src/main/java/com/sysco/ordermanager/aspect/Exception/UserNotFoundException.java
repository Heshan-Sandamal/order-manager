package com.sysco.ordermanager.aspect.Exception;

import com.sysco.ordermanager.web.api.ErrorResponse;

public class UserNotFoundException extends ApiException{

    private static UserNotFoundException userNotFoundException = new UserNotFoundException();

    public UserNotFoundException() {
        super(new ErrorResponse("E001", 404, "User not found", ""));
    }

    public static UserNotFoundException getInstance(){
        return userNotFoundException;
    }
}
