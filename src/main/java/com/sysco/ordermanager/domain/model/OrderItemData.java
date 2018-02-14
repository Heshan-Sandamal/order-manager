package com.sysco.ordermanager.domain.model;



import com.sysco.ordermanager.web.api.Item;
import com.sysco.ordermanager.web.api.Order;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class OrderItemData implements Serializable{

    @EmbeddedId
    private OrderItemId orderItemId;

    @Column
    private double amount;

    public OrderItemData() {
    }

    public OrderItemData(OrderItemId orderItemId, double amount) {
        this.orderItemId=orderItemId;
        this.amount = amount;
    }

    public OrderItemId getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(OrderItemId orderItemId) {
        this.orderItemId = orderItemId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
