package com.sysco.ordermanager.web.api;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Restaurant {

    private String id;

    @NotNull
    @Size(min=2, message="Name should have atleast 2 characters")
    private String address;

    @NotNull
    private User user;

    public Restaurant() {
    }

    public Restaurant(String id, String address, User user) {
        this.id = id;
        this.address = address;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
