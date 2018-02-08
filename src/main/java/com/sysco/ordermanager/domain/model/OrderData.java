package com.sysco.ordermanager.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vibodhab on 2/8/18.
 */
@Entity
@Table(name = "ORDER")
public class OrderData {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "type")
    private String type;

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
