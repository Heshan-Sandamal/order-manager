package com.sysco.ordermanager.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class ItemData implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    public ItemData() {

    }

    public ItemData(String name, String category, String vendor, Integer stock) {
        this.name = name;
        this.category = category;
        this.vendor = vendor;
        this.stock = stock;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Column
    private String name;

    @Column
    private String category;

    @Column
    private String vendor;

    @Column
    private Integer stock;

    @OneToMany(mappedBy = "orderItemId.item")
    private Set<OrderItemData> itemOrders=new HashSet<>();


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getStock() {
        return stock;
    }


    public Set<OrderItemData> getItemOrders() {
        return itemOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemData itemData = (ItemData) o;
        return getId() == itemData.getId() &&
                Objects.equals(getName(), itemData.getName()) &&
                Objects.equals(getCategory(), itemData.getCategory()) &&
                Objects.equals(getVendor(), itemData.getVendor()) &&
                Objects.equals(getStock(), itemData.getStock());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getCategory(), getVendor(), getStock());
    }

    public void setItemOrders(Set<OrderItemData> itemOrders) {
        this.itemOrders = itemOrders;
    }
}
