package com.sysco.ordermanager.web.api;

public class LoginRequest {
    private String name;
    private String password;

    public LoginRequest() {

    }

    public LoginRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
