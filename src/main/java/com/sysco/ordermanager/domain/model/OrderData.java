package com.sysco.ordermanager.domain.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



/**
 * Created by vibodhab on 2/8/18.
 */
@Entity
@Table
public class OrderData implements Serializable {

    @Id
    @Column
    private String id;

    @Column
    private String type;

    @Column
    private int quantity;

    @OneToMany(mappedBy = "order")
    private Set<OrderItemData> orderItems = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserData userData;
    @Column
    private Status status;

    public OrderData() {
    }

    public OrderData(String id, String type, int quantity, UserData userData) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.userData = userData;
        this.status = Status.CREATED;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public Set<OrderItemData> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemData> orderItems) {
        this.orderItems = orderItems;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}