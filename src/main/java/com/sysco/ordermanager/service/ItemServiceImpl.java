package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.repository.ItemRepository;
import com.sysco.ordermanager.service.converter.ItemConverter;
import com.sysco.ordermanager.web.api.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemConverter itemConverter;

    @Override
    public Item getItem(String id) {
        return null;
    }

    @Override
    public Item addItem(Item item) {
        return itemConverter.convertItemDataToItem(itemRepository.save(itemConverter.convertItemToItemData(item)));
    }
}
