package com.sysco.ordermanager.aspect.Exception;

import com.sysco.ordermanager.web.api.ErrorResponse;

public class UserNotFoundException extends ApiException{
    public UserNotFoundException() {
        super(new ErrorResponse("E001", 404, "User not found", ""));
    }
}
