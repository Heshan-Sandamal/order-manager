package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.security.JWTAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
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

    @PostMapping("/sign-up")
    public void signUp(@RequestBody UserData user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @PostMapping("/login")
    public void signIn(@RequestBody UserData user) {
    //        this is hack in order to generate Swagger documentation
    }

}
