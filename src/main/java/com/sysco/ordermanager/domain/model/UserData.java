package com.sysco.ordermanager.domain.model;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
public class UserData {

    private Long id;
    private String name;
    private String password;
    private String passwordConfirm;
    private Set<Role> roles;

    public UserData() {
    }

    public UserData(Long id, String name, String password, String passwordConfirm) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    // TODO: 2/13/18
    // This need to remove
    public UserData(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }


    // TODO: 2/13/18
//    check "userdata_id" ??? can convert userData into user

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userdata_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
