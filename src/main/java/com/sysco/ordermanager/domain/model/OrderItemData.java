package com.sysco.ordermanager.domain.model;



import com.sysco.ordermanager.web.api.Item;
import com.sysco.ordermanager.web.api.Order;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class OrderItemData implements Serializable{


    @Id
    @ManyToOne
    private OrderData order;

    @Id
    @ManyToOne
    private ItemData item;

    @Column
    private double amount;

    public OrderItemData(OrderData order, ItemData item, double amount) {
        this.order = order;
        this.item = item;
        this.amount = amount;
    }

    public OrderData getOrder() {
        return order;
    }

    public void setOrder(OrderData order) {
        this.order = order;
    }

    public ItemData getItem() {
        return item;
    }

    public void setItem(ItemData item) {
        this.item = item;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
