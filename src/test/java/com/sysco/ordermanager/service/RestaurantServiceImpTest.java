package com.sysco.ordermanager.service;

import com.sysco.ordermanager.domain.model.RestaurantData;
import com.sysco.ordermanager.domain.model.UserData;
import com.sysco.ordermanager.domain.repository.RestaurantRepository;
import com.sysco.ordermanager.domain.repository.UserRepository;
import com.sysco.ordermanager.service.converter.RestaurantConverter;
import com.sysco.ordermanager.service.converter.UserConverter;
import com.sysco.ordermanager.web.api.Restaurant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class RestaurantServiceImpTest {

    @TestConfiguration
    static class RestaurantServiceImpTestContextConfiguration{

        @Bean
        public RestaurantService restaurantService(){
            return new RestaurantServiceImp();
        }

        @Bean
        public RestaurantConverter restaurantConverter(){
            return new RestaurantConverter();
        }

        @Bean
        public UserConverter userConverter(){
            return new UserConverter();
        }
    }
    @Autowired
    private RestaurantConverter restaurantConverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RestaurantService restaurantService;

    @MockBean
    private RestaurantRepository restaurantRepository;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setup(){
        UserData userData = new UserData(
<<<<<<< HEAD
                (long)1,
=======
>>>>>>> dev
                "vibodha",
                "123"
        );
        RestaurantData restaurantData = new RestaurantData(
                "1",
                "102/16/1, meegoda",
                userData
        );
<<<<<<< HEAD
        // TODO: 2/13/18
//        remove long to string

        Mockito.when(restaurantRepository.getOne(Long.toString(restaurantData.getUserData().getId())))
=======
        Mockito.when(restaurantRepository.getOne("1"))
>>>>>>> dev
                .thenReturn(restaurantData);

        Mockito.when(userRepository.getOne((long)1))
                .thenReturn(userData);

    }

    @Test
    public void getRestaurant() {
        Restaurant restaurant = restaurantService.getRestaurant("1");
        assertThat(restaurant.getUserDTO().getName()).isEqualTo("vibodha");
    }

//    @Test
//    public void addRestaurant() {
//    }
}