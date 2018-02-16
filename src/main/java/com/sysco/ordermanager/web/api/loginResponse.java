package com.sysco.ordermanager.web.api;

public class loginResponse {
    private Long id;
    private String name;

    public loginResponse() {
    }

    public loginResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
