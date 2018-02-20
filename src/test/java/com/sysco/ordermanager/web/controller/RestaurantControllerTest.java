package com.sysco.ordermanager.web.controller;

import com.sysco.ordermanager.service.RestaurantService;
import com.sysco.ordermanager.web.api.Restaurant;
import com.sysco.ordermanager.web.api.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RestaurantController.class)
@ActiveProfiles(profiles = {"test"})
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestaurantService restaurantService;

    @Test
    public void getUser() throws Exception{
        UserDTO user = new UserDTO(
                (long)1,
                "123"
        );
        Restaurant restaurant = new Restaurant(
                1L,
                "102/16/1, meegoda",
                user
        );

        given(restaurantService.getRestaurant(1L)).willReturn(restaurant);

        mvc.perform(get("/api/restaurant/1")
//                .header("authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiZXhwIjoxNTE5NjQzODgxfQ.w0rvRggZuKKpbdZCBdICfC5IlfLMA9_AmHO6TVc201T6pr6BW9EchvqHnGjj5lrjvbw_oM7PRNaTps6gfaAKrg")
//                .header(HttpHeaders.AUTHORIZATION,"Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiZXhwIjoxNTE5NjQzODgxfQ.w0rvRggZuKKpbdZCBdICfC5IlfLMA9_AmHO6TVc201T6pr6BW9EchvqHnGjj5lrjvbw_oM7PRNaTps6gfaAKrg")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiZXhwIjoxNTE5NjQzODgxfQ.w0rvRggZuKKpbdZCBdICfC5IlfLMA9_AmHO6TVc201T6pr6BW9EchvqHnGjj5lrjvbw_oM7PRNaTps6gfaAKrg")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

//    @Test
//    public void addRestaurant() {
//    }
}