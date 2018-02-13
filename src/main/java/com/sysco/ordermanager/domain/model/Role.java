package com.sysco.ordermanager.domain.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Role {
    private Long id;
    private String name;
    private Set<UserData> users;

    public Role() {
    }

    public Role(Long id, String name, Set<UserData> users) {
        this.id = id;
        this.name = name;
        this.users = users;
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

    @ManyToMany(mappedBy = "roles")
    public Set<UserData> getUsers() {
        return users;
    }

    public void setUsers(Set<UserData> users) {
        this.users = users;
    }
}
