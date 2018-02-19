package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.service.ItemService;
import com.sysco.ordermanager.web.api.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/")
    public ResponseEntity<Item> addItem(@Valid @RequestBody Item item){
        return new ResponseEntity<Item>(itemService.addItem(item), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Item>> getItems(){
        return new ResponseEntity<List<Item>>(itemService.getItem(), HttpStatus.OK);
    }
}
