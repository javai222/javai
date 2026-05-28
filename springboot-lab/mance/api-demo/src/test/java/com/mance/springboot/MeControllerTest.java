package com.mance.springboot;

import com.mance.springboot.controller.MeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureWebMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @Author @Fayemaya (Mance, John Roque R.)
 *
 *  Q1: How did you create your Spring Boot project?
 *  A1: I created my spring boot project using spring initializr
 *
 *  Q2: What is the purpose of the @RestController annotation?
 *  A2: It lets Spring Boot know that the class will handle web requests and automatically return data to the user.
 *
 *  Q3: What does the @GetMapping("/me") annotation do?
 *  A3: It tells Spring Boot to handle GET requests for the /me URL and run that method when it’s accessed.
 *
 *  Q4: Why did you change from returning a String to a Map?
 *  A4: Because the map has keys and value that makes it useful when calling @GetMapping("/me")
 *
 *  Q5: How does Spring Boot handle JSON responses automatically?
 *  A5: Because it includes Jackson library by default
 *
 */

@SpringBootTest
@AutoConfigureWebMvc
public class MeControllerTest {

    @Autowired
    private MeController Controller;

    private MockMvc mockMvc = standaloneSetup(Controller).build();

    @Test
    public void TestGetMe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").exists());
    }
}
