package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.service.converter.UserConverter;
import com.sysco.ordermanager.web.api.LoginRequest;
import com.sysco.ordermanager.web.api.User;
import com.sysco.ordermanager.web.api.loginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public loginResponse signUp(User user) {
        return userConverter.convertUserDataToUserResponse(userRepository.save(userConverter.convertUserToUserData(user)));
    }

    @Override
    public loginResponse signIn(LoginRequest loginRequest) {
        return userConverter.convertUserDataToUserResponse(userRepository.findByNameAndPassword(loginRequest.getName(), loginRequest.getPassword()));
    }
}
