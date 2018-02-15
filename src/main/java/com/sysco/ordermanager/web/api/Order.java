package com.sysco.ordermanager.web.api;

import java.util.Set;

/**
 * Created by vibodhab on 2/8/18.
 */
public class Order {
    private Long id;
    private String type;
    private User user;
    private Set<OrderItem> orderItems;

    public Order(Long id, String type, User user) {
        this.id = id;
        this.type = type;
        this.user = user;
    }


    public Order(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Order(Long id, String type, Set<OrderItem> orderItems) {
        this.id = id;
        this.type = type;
        this.orderItems = orderItems;
    }

    public Order(String type) {
        this.type = type;
    }

    public Order(String type, User user) {
        this.type = type;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
