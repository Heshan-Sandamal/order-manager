package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.web.api.User;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {
    public User convertUserDataToUser(UserData userData){
        return new User(
                userData.getId(),
                userData.getName(),
                userData.getPassword()
        );
    }

    public UserData convertUserToUserData(User user){
        return new UserData(
                user.getId(),
                user.getName(),
                user.getPassword()
        );
    }
}
