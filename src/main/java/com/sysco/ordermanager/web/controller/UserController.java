package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.service.UserService;
import com.sysco.ordermanager.web.api.LoginRequest;
import com.sysco.ordermanager.web.api.SignUpRequest;
import com.sysco.ordermanager.web.api.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.security.Principal;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

//    @PostMapping("/sign-up")
//    public void signUp(@RequestBody UserData user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }

    @PostMapping("/signUp")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpRequest signUpRequest) {
        return new ResponseEntity<>(
                userService.signUp(signUpRequest),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/login")
    public void signIn(@RequestBody LoginRequest user) {
    //        this is hack in order to generate Swagger documentation
    }


    @GetMapping("/")
    public ResponseEntity<UserDTO> getUser(Principal principal){
        return new ResponseEntity<>(
                userService.getUser(Long.valueOf(principal.getName())),
                HttpStatus.FOUND
        );
    }


    //    @GetMapping("/")
//    public void getUser(Principal principal){
//        System.out.println("__________test2___________");
//        System.out.println(principal.getName());
//        UserData user = userRepository.findOne(Long.valueOf(principal.getName()));
////        UserData user = userRepository.findOne((long)12111);
//        if (user == null){
//            System.out.println("Null user");
//        }else{
//            System.out.println(user.getName());
//            System.out.println(user.getId());
//            System.out.println(user.getPassword());
//        }
//
//    }


}
