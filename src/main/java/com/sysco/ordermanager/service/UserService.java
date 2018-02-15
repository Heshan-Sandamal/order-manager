package com.sysco.ordermanager.service;

import com.sysco.ordermanager.web.api.LoginRequest;
import com.sysco.ordermanager.web.api.User;
import com.sysco.ordermanager.web.api.loginResponse;

public interface UserService {
    loginResponse signUp(User user);
    loginResponse signIn(LoginRequest loginRequest);
}
