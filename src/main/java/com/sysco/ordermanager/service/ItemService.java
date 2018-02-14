package com.sysco.ordermanager.service;

import com.sysco.ordermanager.web.api.Item;

public interface ItemService {

    Item getItem(String id);
    Item addItem(Item item);

}
