package com.sysco.ordermanager.web.api;

public class Restaurant {

    private String id;
    private String address;
    private String owner;

    public Restaurant() {
    }

    public Restaurant(String id, String address, String owner) {
        this.id = id;
        this.address = address;
        this.owner = owner;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
