package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.web.api.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {
    public UserDTO convertUserDataToUser(UserData userData){
        return new UserDTO(
                Long.toString(userData.getId()),
                userData.getName(),
                null
        );
    }

    public UserData convertUserToUserData(UserDTO userDTO){
        return new UserData(
                Long.valueOf(userDTO.getId()),
                userDTO.getName(),
                userDTO.getPassword()
        );
    }

    // TODO: 2/13/18
//    public loginResponse convertUserDataToUserResponse(UserData userdata){
//        return new loginResponse(
//                userdata.getId(),
//                userdata.getName()
//        );
//    }
}
