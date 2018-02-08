package com.sysco.ordermanager.web.api;

/**
 * Created by vibodhab on 2/8/18.
 */
public class Order {
    private String id;
    private String type;

    public Order(String id, String type) {
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
