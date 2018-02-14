package com.sysco.ordermanager.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserData {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String password;

    @OneToMany(mappedBy="userData")
    private Set<OrderData> orders;

    public UserData() {
    }

    public UserData(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
