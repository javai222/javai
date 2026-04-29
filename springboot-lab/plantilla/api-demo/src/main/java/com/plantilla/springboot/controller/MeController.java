package com.plantilla.springboot.controller;

// Created by Plantilla, Jophel Mark P.

//Code-Based Analysis
/*
 * How did you create your Spring Boot project?
 * - I used Spring Initializr to generate the Maven Project and just add Spring Web dependency.
 *
 * What is the purpose of the @RestController annotation?
 * - It handles HTTP requests and returns the JSON responses.
 *
 * What does the @GetMapping("/me") annotation do?
 * - It maps the GET requests to the /me endpoint and calls the getMe() method.
 *
 * Why did you change from returning a String to a Map?
 * - I change it to return the proper JSON response instead of just a plain text string.
 *
 * How does Spring Boot handle JSON responses automatically?
 * - It uses Jackson library to automatically convert Java objects to JSON.
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Jophel Mark P. Plantilla");
        response.put("studentId", "2025-1026473");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }

}

