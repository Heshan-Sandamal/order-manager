package com.sysco.ordermanager.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class RestaurantData {

    @Id
    @Column
    private String id;

    @Column
    private String address;

    @Column
    private String owner;

    public RestaurantData() {
    }

    public RestaurantData(String id, String address, String owner) {
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
