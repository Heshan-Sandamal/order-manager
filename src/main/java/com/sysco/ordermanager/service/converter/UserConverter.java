package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.web.api.LoginRequest;
import com.sysco.ordermanager.web.api.SignUpRequest;
import com.sysco.ordermanager.web.api.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    public UserData convertUserToUserData(UserDTO userDTO){
        // TODO: 2/16/18
        return new UserData(
                userDTO.getId(),
                userDTO.getName(),
                ""
        );
    }

    public UserData convertLoginRequestToUserData(SignUpRequest signUpRequest){
        return new UserData(
                (long)0,
                signUpRequest.getName(),
                signUpRequest.getPassword()
        );
    }

    public UserDTO convertUserDataToUserDTO(UserData userData){
        return new UserDTO(
                userData.getId(),
                userData.getName()
        );

    }
}
