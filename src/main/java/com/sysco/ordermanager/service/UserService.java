package com.sysco.ordermanager.service;

import com.sysco.ordermanager.web.api.LoginRequest;
import com.sysco.ordermanager.web.api.User;
import com.sysco.ordermanager.web.api.loginResponse;

public interface UserService {
    public loginResponse signUp(User user);
    public loginResponse signIn(LoginRequest loginRequest);
}
