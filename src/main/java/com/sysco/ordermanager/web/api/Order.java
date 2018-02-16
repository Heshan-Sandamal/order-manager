package com.sysco.ordermanager.web.api;

import com.sysco.ordermanager.util.enums.OrderStatus;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by vibodhab on 2/8/18.
 */
public class Order {
    private Long id;
    private String type;
    private User user;
    private OrderStatus orderStatus;
    private Set<OrderItem> orderItems;

    public Order() {
    }

    public Order(Long id, String type, User user, OrderStatus orderStatus) {
        this.id = id;
        this.type = type;
        this.user = user;
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }

    public Order(String type, User user, OrderStatus orderStatus) {
        this.type = type;
        this.user = user;

        this.orderStatus = orderStatus;
    }

    public Order(Long id, String type, User user, OrderStatus orderStatus, Set<OrderItem> orderItems) {
        this.id = id;
        this.type = type;
        this.user = user;
        this.orderStatus = orderStatus;
        this.orderItems = orderItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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
