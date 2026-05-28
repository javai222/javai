package com.saan.demo.Controller;

/**
 * @Author @kozthh(kenneth Saan)
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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class humancontroller {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Kenneth Saan");
        response.put("studentId", "2025-1022880");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}









