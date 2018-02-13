package com.sysco.ordermanager.service;
import com.sysco.ordermanager.aspect.Exception.ApiException;
import com.sysco.ordermanager.web.api.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice( )
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> apiExceptions(ApiException apiException) {
        return ResponseEntity.status(apiException.getErrorResponse().getHttpStatusCode()).
                body(apiException.getErrorResponse());
    }


}
