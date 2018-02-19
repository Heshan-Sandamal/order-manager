package com.sysco.ordermanager.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class RestaurantData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String address;

    @OneToOne
    private UserData userData;

    public RestaurantData() {
    }

    public RestaurantData(String address, UserData userData) {
        this.address = address;
        this.userData = userData;
    }

    public RestaurantData(long id, String address, UserData userData) {
        this.id = id;
        this.address = address;
        this.userData = userData;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
