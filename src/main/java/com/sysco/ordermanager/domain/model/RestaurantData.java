package com.sysco.ordermanager.domain.model;

import javax.persistence.*;

@Entity
@Table
public class RestaurantData {

    @Id
    @Column
    private String id;

    @Column
    private String address;

    @OneToOne
    private UserData userData;

    public RestaurantData() {
    }

    public RestaurantData(String id, String address, UserData userData) {
        this.id = id;
        this.address = address;
        this.userData = userData;
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

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
