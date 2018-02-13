package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.repository.ItemRepository;
import com.sysco.ordermanager.web.api.Item;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item getItem(String id) {
        return null;
    }

    @Override
    public Item addItem(Item item) {
        return null;
    }
}
