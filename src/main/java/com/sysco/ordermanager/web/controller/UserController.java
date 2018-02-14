package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.service.UserService;
import com.sysco.ordermanager.web.api.LoginRequest;
import com.sysco.ordermanager.web.api.User;
import com.sysco.ordermanager.web.api.loginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody UserData user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

// TODO: 2/13/18
//    @PostMapping("/signUp")
//    public ResponseEntity<loginResponse> signUp(@RequestBody User user){
//        return new ResponseEntity<>(userService.signUp(user), HttpStatus.CREATED);
//    }
//
//    @PostMapping("/signIn")
//    public ResponseEntity<loginResponse>signIn(@RequestBody LoginRequest loginRequest){
//        return new ResponseEntity<>(userService.signIn(loginRequest),HttpStatus.FOUND);
//    }
}
