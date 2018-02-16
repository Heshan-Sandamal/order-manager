package com.sysco.ordermanager.domain.model;


import com.sysco.ordermanager.util.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
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

    private String type;

    @OneToMany(mappedBy = "orderItemId.order", cascade = {CascadeType.ALL})
    private Set<OrderItemData> orderItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserData userData;

    private OrderStatus orderStatus;

    public OrderData(String type, UserData userData) {
        this.type = type;
        this.userData = userData;
    }

    public OrderData() {
    }

    public OrderData(String type, UserData userData, OrderStatus orderStatus) {
        this.type = type;
        this.userData = userData;
        this.orderStatus = orderStatus;
    }

    public Set<OrderItemData> getItems() {
        return orderItems;
    }

    public void setItems(Set<OrderItemData> orderItems) {
        this.orderItems = orderItems;
        this.orderStatus = OrderStatus.CREATED;

    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderData orderData = (OrderData) o;
        return Objects.equals(getId(), orderData.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}