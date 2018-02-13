package com.sysco.ordermanager.web.api;

/**
 * Created by vibodhab on 2/8/18.
 */
public class Order {
    private String id;
    private String type;
    private int quantity;
    private User user;

    public Order(String id, String type, int quantity, User user) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.user = user;
    }

    public Order(String id, String type, int quantity) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
