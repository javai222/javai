// created by casapao

/*
* How did you create your Spring Boot project?
* I created the Spring Boot project using Spring Initializr, which sets up the basic project structure for me.
* What is the purpose of the @RestController annotation?
* @RestController is used to make a class handle web requests and return data as a response.
* What does the @GetMapping("/me") annotation do?
* @GetMapping("/me") connects a GET request for /me to a specific method.
* Why did you change from returning a String to a Map?
* I changed from String to Map so I can return structured data in JSON format.
* How does Spring Boot handle JSON responses automatically?
* Spring Boot automatically converts Java objects into JSON using built-in tools like Jackson.
*/

package com.casapao.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Jasmin Ann M. Casapao");
        response.put("studentId", "2025-1020028");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}