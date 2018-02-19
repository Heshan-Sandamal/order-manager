package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.repository.ItemRepository;
import com.sysco.ordermanager.service.converter.ItemConverter;
import com.sysco.ordermanager.web.api.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemConverter itemConverter;

    @Override
    public Item getItem(long id) {
        return null;
    }

    @Override
    public Item addItem(Item item) {
        return itemConverter.convertItemDataToItem(itemRepository.save(itemConverter.convertItemToItemData(item)));
    }

    @Override
    public List<Item> getItem() {
        return itemRepository.findAll().stream()
                .map(itemData -> itemConverter.convertItemDataToItem(itemData))
                .collect(Collectors.toList());
    }
}
