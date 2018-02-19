package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.service.converter.UserConverter;
import com.sysco.ordermanager.web.api.SignUpRequest;
import com.sysco.ordermanager.web.api.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO getUser(long id) {
        UserData userData = userRepository.findOne(id);
        if(userData == null){
            throw new UsernameNotFoundException(Long.toString(id));
        }
        return userConverter.convertUserDataToUserDTO(userData);
    }

    @Override
    public UserDTO signUp(SignUpRequest signUpRequest) {
        signUpRequest.setPassword(bCryptPasswordEncoder.encode(signUpRequest.getPassword()));
        return userConverter.convertUserDataToUserDTO(userRepository.save(userConverter.convertLoginRequestToUserData(signUpRequest)));
    }
}
