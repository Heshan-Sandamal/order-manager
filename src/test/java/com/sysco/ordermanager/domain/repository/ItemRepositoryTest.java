package com.sysco.ordermanager.domain.repository;

import com.sysco.ordermanager.domain.model.ItemData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class) // need for assert functions
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void addItemTest(){
        ItemData itemData = new ItemData(
            "item1",
            "cat1",
            "ven1",
            30
        );
        ItemData itemData1 = itemRepository.save(itemData);



    }
}