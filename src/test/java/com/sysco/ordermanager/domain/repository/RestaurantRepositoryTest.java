package com.sysco.ordermanager.domain.repository;


import com.sysco.ordermanager.domain.model.RestaurantData;
import com.sysco.ordermanager.domain.model.UserData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = {"test"})
@DataJpaTest
public class RestaurantRepositoryTest {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void createRestaurant() {

        UserData userData = new UserData(
                "vibodha",
                "123"
        );

        UserData userData1 = entityManager.persist(userData);
        entityManager.flush();

        RestaurantData restaurantData = new RestaurantData(
                "102/16/1, meegoda",
                userData
        );

        RestaurantData restaurantData1 = entityManager.persist(restaurantData);
        entityManager.flush();

        System.out.println(userData1.getId());

        UserData userFound = userRepository.getOne(userData1.getId());
        RestaurantData restaurantFound = restaurantRepository.getOne(restaurantData1.getId());
        assertThat(userFound).isEqualTo(restaurantData.getUserData());

    }
}