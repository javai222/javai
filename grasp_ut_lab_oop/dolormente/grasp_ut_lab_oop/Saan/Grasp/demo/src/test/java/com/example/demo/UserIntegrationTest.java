package com.example.demo;

import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void createAndGetUsers() throws Exception {
        // Arrange
        String json = "[{\"name\":\"Maria\",\"program\":\"BSIT\"}]";

        // Act - create
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$[0].name").value("Maria"));

        // Act - get all
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Maria"));
    }

    @Test
    void deleteUser_returnsOk() throws Exception {
        // Arrange - create user first
        String json = "[{\"name\":\"John\",\"program\":\"BSCS\"}]";

        String response = mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn().getResponse().getContentAsString();

        // extract id manually from response string
        String idStr = response.split("\"id\":")[1].split(",")[0];

        // Act & Assert
        mockMvc.perform(delete("/api/users/" + idStr))
                .andExpect(status().isOk());
    }

    @Test
    void getUserNotFound_returns404() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/api/users/999"))
                .andExpect(status().isNotFound());
    }
}