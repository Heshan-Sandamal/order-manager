package com.sysco.ordermanager.domain.model;



import com.sysco.ordermanager.web.api.Item;
import com.sysco.ordermanager.web.api.Order;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_item")
public class OrderItemData implements Serializable{


    @Id
    @ManyToOne
    private OrderData orderData;

    @Id
    @ManyToOne
    private ItemData itemData;

    @Column
    private double amount;

    public OrderItemData(OrderData order, ItemData item, double amount) {
        this.orderData = order;
        this.itemData = item;
        this.amount = amount;
    }

    public OrderData getOrder() {
        return orderData;
    }

    public void setOrder(OrderData order) {
        this.orderData = order;
    }

    public ItemData getItem() {
        return itemData;
    }

    public void setItem(ItemData item) {
        this.itemData = item;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
