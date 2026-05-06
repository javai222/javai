package com.mance.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

@RestController
public class MeController {

//    @GetMapping("/me")
//    public String getMe(){
//        return "Hello' I am John Roque R. Mance";
//    }

    @GetMapping("/me")
    public Map<String,Object> getMe(){
        Map<String,Object> response = new HashMap<>();
        response.put("name", "John Roque R. Mance");
        response.put("studentId", "2025-1024907");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring boot");
        return response;
    }
}
