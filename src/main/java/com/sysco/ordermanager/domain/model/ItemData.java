package com.sysco.ordermanager.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "item")
public class ItemData implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

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

    public ItemData(String name, String category, String vendor, Integer stock) {
        this.name = name;
        this.category = category;
        this.vendor = vendor;
        this.stock = stock;
    }

    public ItemData() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public Set<OrderItemData> getItemOrders() {
        return itemOrders;
    }

    public void setItemOrders(Set<OrderItemData> itemOrders) {
        this.itemOrders = itemOrders;
    }
}
