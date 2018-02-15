package com.sysco.ordermanager.web.api;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by vibodhab on 2/8/18.
 */
public class Order{
    private Long id;
    private String type;
    private int quantity;
    private User user;
    private Set<OrderItem> orderItems;

    public Order(Long id, String type, int quantity, User user, Set<OrderItem> orderItems) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.user = user;
        this.orderItems = orderItems;
    }

    public Order(Long id, String type, int quantity, User user) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.user = user;
    }

    public Order() {
    }

    public Order(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public Order(String type, int quantity, User user) {
        this.type = type;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
