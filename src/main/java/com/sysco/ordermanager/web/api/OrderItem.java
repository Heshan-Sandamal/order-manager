package com.sysco.ordermanager.web.api;

public class OrderItem {

    private Order order;
    private Item item;
    private double amount;


    public OrderItem(Order order, Item item, double amount) {
        this.order = order;
        this.item = item;
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
