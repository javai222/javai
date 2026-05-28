package com.saan.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * How did you create your Spring Boot project?
 * I created it using gradle build tools and also I studied how Rest Api works
 *
 * What is the purpose of the @RestController annotation?
 * it is for the springboot to recognize the class file then the springboot will automatically process it
 *
 * What does the @GetMapping("/me") annotation do?
 * specialized annotation used to map HTTP GET requests to specific handler methods in your controller.
 *
 * Why did you change from returning a String to a Map?
 * because map has key and value
 *
 * How does Spring Boot handle JSON responses automatically?
 *
 * Spring Boot's ability to turn a Java object into a JSON string without you writing a
 * single line of parsing code feels like magic, but it is actually a well-coordinated
 * handoff between a few internal components.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class HumanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetMe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/me"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").exists());
    }
}