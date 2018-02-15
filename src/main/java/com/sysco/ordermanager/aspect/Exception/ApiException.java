package com.sysco.ordermanager.aspect.Exception;

import com.sysco.ordermanager.web.api.ErrorResponse;

public class ApiException extends RuntimeException {

    private final ErrorResponse errorResponse;

    public ApiException(ErrorResponse errorResponse){
        super();
        this.errorResponse = errorResponse;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
