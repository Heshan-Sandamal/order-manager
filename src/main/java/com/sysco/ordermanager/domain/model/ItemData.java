package com.sysco.ordermanager.domain.model;

import javax.persistence.*;

@Entity
@Table
public class ItemData {

    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String category;

    @Column
    private String vendor;

    @Column
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = true)
    private OrderData order;


    public String getId() {
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


}
