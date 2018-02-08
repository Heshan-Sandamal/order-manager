package com.sysco.ordermanager.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vibodhab on 2/8/18.
 */
@Entity
@Table
public class OrderData {

    @Id
    @Column
    private String id;

    @Column
    private String type;

    public OrderData() {
    }

    public OrderData(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
