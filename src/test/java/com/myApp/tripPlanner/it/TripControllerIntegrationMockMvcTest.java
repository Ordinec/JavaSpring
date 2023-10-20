package com.myApp.tripPlanner.it;

import com.myApp.tripPlanner.services.TripService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles = "USER")
public class TripControllerIntegrationMockMvcTest {
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    private String addTripJson = """
            {
                "id": 1.
                "name": "Test" 
                "waypoints":[]
            }
            """;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetTrip() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/trip/getTrip"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("id"))
                .andExpect(MockMvcResultMatchers.content().string("name"));
    }

    @Test
    public void testAddTrip() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/trip/addTrip")
                .contentType(APPLICATION_JSON_UTF8)
                .content(addTripJson))
                .andExpect(status().isOk());
    }
}
