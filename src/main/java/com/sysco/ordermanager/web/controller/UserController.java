package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.service.UserService;
import com.sysco.ordermanager.web.api.LoginRequest;
import com.sysco.ordermanager.web.api.User;
import com.sysco.ordermanager.web.api.loginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<loginResponse> signUp(@RequestBody User user){
        return new ResponseEntity<>(userService.signUp(user), HttpStatus.CREATED);
    }

    @PostMapping("/signIn")
    public ResponseEntity<loginResponse>signIn(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(userService.signIn(loginRequest),HttpStatus.FOUND);
    }
}
