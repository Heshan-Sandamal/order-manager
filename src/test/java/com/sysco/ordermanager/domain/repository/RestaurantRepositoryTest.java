package com.sysco.ordermanager.domain.repository;

import com.sysco.ordermanager.domain.model.RestaurantData;
import com.sysco.ordermanager.domain.model.UserData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.EntityManager;
import static org.assertj.core.api.Assertions.*;


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
    public void createRestaurant(){

        UserData userData = new UserData(
                (long)1,
                "vibodha",
                "123"
        );

        entityManager.persist(userData);
        entityManager.flush();

        RestaurantData restaurantData = new RestaurantData(
                "1",
                "102/16/1, meegoda",
                userData
        );

        entityManager.persist(restaurantData);
        entityManager.flush();

        UserData userFound = userRepository.getOne((long)1);
        RestaurantData restaurantFound = restaurantRepository.getOne("1");
        assertThat(userFound).isEqualTo(restaurantData.getUserData());

    }

}