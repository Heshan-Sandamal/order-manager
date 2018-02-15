package com.sysco.ordermanager.domain.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by vibodhab on 2/8/18.
 */
@Entity
@Table(name = "order_t")
public class OrderData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String type;

    @OneToMany(mappedBy = "orderItemId.order", cascade = {CascadeType.ALL})
    private Set<OrderItemData> orderItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserData userData;

    @Column
    private Status status;

    public OrderData(String type, UserData userData) {
        this.type = type;
        this.userData = userData;
    }

    public OrderData() {
    }

    public OrderData(Long id, String type, Set<OrderItemData> orderItems) {
        this.id = id;
        this.type = type;
        this.orderItems = orderItems;
        this.userData = userData;
        this.status = Status.CREATED;
    }

    public Set<OrderItemData> getItems() {
        return orderItems;
    }

    public void setItems(Set<OrderItemData> orderItems) {
        this.orderItems = orderItems;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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