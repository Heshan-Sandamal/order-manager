package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.web.api.User;
import com.sysco.ordermanager.web.api.loginResponse;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {
    public User convertUserDataToUser(UserData userData){
        return new User(
                Long.toString(userData.getId()),
                userData.getName(),
                null
        );
    }

    public UserData convertUserToUserData(User user){
        return new UserData(
                Long.valueOf(user.getId()),
                user.getName(),
                user.getPassword()
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
