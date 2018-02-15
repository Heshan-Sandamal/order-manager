package com.sysco.ordermanager.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String password;

    @OneToMany(mappedBy="userData")
    private Set<OrderData> orders;

    public UserData() {
    }

    public UserData(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserData(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
