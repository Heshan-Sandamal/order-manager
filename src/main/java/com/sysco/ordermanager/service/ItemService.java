package com.sysco.ordermanager.service;

import com.sysco.ordermanager.web.api.Item;

import java.util.List;

public interface ItemService {

    Item getItem(long id);
    Item addItem(Item item);
    List<Item> getItem();

}
