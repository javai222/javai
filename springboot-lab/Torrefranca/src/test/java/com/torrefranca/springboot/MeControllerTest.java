package com.torrefranca.springboot;

import com.torrefranca.springboot.controller.MeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureWebMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
@AutoConfigureWebMvc
public class MeControllerTest {

    @Autowired
    private MeController meController;

    private MockMvc mockMvc = standaloneSetup(meController).build();

    @Test
    public void testGetMe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").exists());
    }
}

/**
 * Made by Vincent Torrefranca (v1nncy)
 *
 * 1: How did you create your Spring Boot project?
 * I created the project using Spring Initializr by selecting a Gradle project, choosing Java, and adding the necessary dependencies (such as Spring Web)
 *
 * 2: What is the purpose of the @RestController annotation?
 * It tells Spring that the class will handle API requests and return data.
 *
 * 3: What does the @GetMapping("/me") annotation do?
 * It makes a URL endpoint /me that runs a method when someone sends a GET request to it.
 *
 * 4: Why did you change from returning a String to a Map?
 * Because a Map can hold multiple values, and it’s easier to turn into JSON.
 *
 * 5: How does Spring Boot handle JSON responses automatically?
 * Spring Boot automatically converts Java objects into JSON using a built-in library, so we don’t have to do it manually.
 *
 */
