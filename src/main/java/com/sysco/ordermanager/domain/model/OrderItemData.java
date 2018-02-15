package com.sysco.ordermanager.domain.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_item")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemData that = (OrderItemData) o;
        return Double.compare(that.getAmount(), getAmount()) == 0 &&
                Objects.equals(getOrderItemId(), that.getOrderItemId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getOrderItemId(), getAmount());
    }
}
