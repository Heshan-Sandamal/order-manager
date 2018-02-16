package com.sysco.ordermanager.web.api;


public class SignUpRequest {
    private String name;
    private String password;

    public SignUpRequest() {
    }

    public SignUpRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
