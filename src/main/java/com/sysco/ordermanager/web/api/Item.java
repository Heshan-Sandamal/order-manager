package com.sysco.ordermanager.web.api;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Item {
    private int id;
    private String name;
    private String category;
    private String vendor;
    private int stock;

    public Item(int id, String name, String category, String vendor, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.vendor = vendor;
        this.stock = stock;
    }

    public Item(String name, String category, String vendor, int stock) {
        this.name = name;
        this.category = category;
        this.vendor = vendor;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
