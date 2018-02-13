package com.sysco.ordermanager.web.api;

public class loginResponse {
    private String id;
    private String name;

    public loginResponse() {
    }

    public loginResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
