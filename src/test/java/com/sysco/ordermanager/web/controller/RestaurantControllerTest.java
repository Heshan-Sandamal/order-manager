package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.service.RestaurantService;
import com.sysco.ordermanager.web.api.Restaurant;
import com.sysco.ordermanager.web.api.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestaurantService restaurantService;

    @Test
    public void getUser() throws Exception{
        User user = new User(
                "1",
                "vibodha",
                "123"
        );
        Restaurant restaurant = new Restaurant(
                "1",
                "102/16/1, meegoda",
                user
        );

        given(restaurantService.getRestaurant("1")).willReturn(restaurant);

        mvc.perform(get("/restaurant/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

//    @Test
//    public void addRestaurant() {
//    }
}