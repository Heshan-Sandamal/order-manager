package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.service.converter.UserConverter;
import com.sysco.ordermanager.web.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public User signUp(User user) {
        return userConverter.convertUserDataToUser(userRepository.save(userConverter.convertUserToUserData(user)));
    }
}
