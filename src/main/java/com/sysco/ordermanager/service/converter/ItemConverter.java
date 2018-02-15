package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.ItemData;
import com.sysco.ordermanager.web.api.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemConverter {

    public ItemData convertItemToItemData(Item item){
        ItemData itemData = new ItemData(item.getName(), item.getCategory(), item.getVendor(), item.getStock());
        return itemData;
    }


    public ItemData convertItemToItemDataWithId(Item item){
        ItemData itemData = new ItemData();
        itemData.setId(item.getId());
        return itemData;
    }

    public Item convertItemDataToItem(ItemData itemData){
        return new Item(itemData.getId(),itemData.getName(),itemData.getCategory(),itemData.getVendor(),itemData.getStock());
    }

}
