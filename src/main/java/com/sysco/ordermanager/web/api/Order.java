package com.sysco.ordermanager.web.api;

import com.sysco.ordermanager.util.enums.OrderStatus;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vibodhab on 2/8/18.
 */
public class Order {
    private Long id;
    private String type;
    private UserDTO userDTO;
    private OrderStatus orderStatus;
    private Set<OrderItem> orderItems;

    public Order() {
    }

    public Order(Long id, String type, UserDTO userDTO, OrderStatus orderStatus) {
        this.id = id;
        this.type = type;
        this.userDTO = userDTO;
        this.orderStatus = orderStatus;
    }

    public Order(String type, UserDTO userDTO, OrderStatus orderStatus) {
        this.type = type;
        this.userDTO = userDTO;
        this.orderStatus = orderStatus;
    }

    public Order(Long id, String type, UserDTO userDTO, OrderStatus orderStatus, Set<OrderItem> orderItems) {
        this.id = id;
        this.type = type;
        this.userDTO = userDTO;
        this.orderStatus = orderStatus;
        this.orderItems = orderItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public UserDTO getUser() {
        return userDTO;
    }

    public void setUser(UserDTO userDTO) {
        this.userDTO = userDTO;
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
