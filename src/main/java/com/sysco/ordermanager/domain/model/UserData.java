package com.sysco.ordermanager.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserData {

    @Id
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String password;

    public UserData() {
    }

    public UserData(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
