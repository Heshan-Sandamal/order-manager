package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.web.api.SignUpRequest;
import com.sysco.ordermanager.web.api.UserDTO;

public interface UserService {
    UserDTO getUser(long id);

    UserDTO signUp(SignUpRequest signUpRequest);

}