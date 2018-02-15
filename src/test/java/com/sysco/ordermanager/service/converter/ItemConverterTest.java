package com.sysco.ordermanager.service.converter;

import com.sysco.ordermanager.domain.model.ItemData;
import com.sysco.ordermanager.web.api.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = {"test"})
@WebAppConfiguration
@SpringBootTest
public class ItemConverterTest {

    final Integer ID=3;
    final String NAME="test-name";
    final String CATEGORY="test-category";
    final String VENDOR="test-vendor";
    final Integer STOCK=2;

    @Autowired
    ItemConverter itemConverter;

    @Test
    public void convertItemToItemData() {

        Item item=new Item(NAME,CATEGORY,VENDOR,STOCK);
        ItemData itemData=new ItemData(NAME,CATEGORY,VENDOR,STOCK);

        ItemData convertedItemData = itemConverter.convertItemToItemData(item);
        assertEquals(convertedItemData,itemData);
    }

    @Test
    public void convertItemToItemDataWithId() {
        Item item=new Item();
        item.setId(ID);

        ItemData itemData=new ItemData();
        itemData.setId(ID);

        ItemData convertedItemData = itemConverter.convertItemToItemDataWithId(item);
        assertEquals(convertedItemData,itemData);
    }

    @Test
    public void convertItemDataToItem() {
        ItemData itemData=new ItemData(NAME,CATEGORY,VENDOR,STOCK);
        itemData.setId(ID);

        Item item=new Item(NAME,CATEGORY,VENDOR,STOCK);
        item.setId(ID);

        Item convertedItem = itemConverter.convertItemDataToItem(itemData);
        assertEquals(item,convertedItem);
    }
}