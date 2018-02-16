package com.sysco.ordermanager.service;

import com.sysco.ordermanager.aspect.Exception.RestaurantNotFoundException;
import com.sysco.ordermanager.domain.model.RestaurantData;
import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.domain.repository.RestaurantRepository;
import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.web.api.Restaurant;
import com.sysco.ordermanager.web.api.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = {"test"})
@WebAppConfiguration
@SpringBootTest
public class RestaurantServiceImpIntTest {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserRepository userRepository;

    @Test(expected = RestaurantNotFoundException.class)
    public void updateRestaurantTest(){
        UserData userData = new UserData(1L, "vibodha", "123");
        userRepository.save(userData);

        RestaurantData restaurantData = new RestaurantData("1", "102/16, sdfsd", userData);
        restaurantRepository.save(restaurantData);

        UserDTO user = new UserDTO(1L, "vibodha");
        Restaurant updatedRestaurant = new Restaurant("2", "102/13, sddfdffsd", user);

        restaurantService.updateRestaurant(updatedRestaurant);

//        RestaurantData updatedRestaurantData = restaurantRepository.findOne("1");
//
//        assertThat(updatedRestaurantData.getAddress()).isEqualTo(updatedRestaurant.getAddress());



    }
}