package com.sysco.ordermanager.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemId implements Serializable {

    @ManyToOne
    private OrderData order;

    @ManyToOne
    private ItemData item;

    public OrderItemId() {
    }

    public OrderItemId(OrderData order, ItemData item) {
        this.order = order;
        this.item = item;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemId that = (OrderItemId) o;
        return Objects.equals(getOrder(), that.getOrder()) &&
                Objects.equals(getItem(), that.getItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder(), getItem());
    }


}
