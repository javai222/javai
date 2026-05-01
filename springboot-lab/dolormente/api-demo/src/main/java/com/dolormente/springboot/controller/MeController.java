/* 
* Created by Dolormente, Henry II S.
* Q1: How did you create your Spring Boot project?
* - I made this porject with the help of my friends, spring initializr, codespace, and AI.
*
* Q2: What is the purpose of the @RestController annotation?
* - It tells Spring that the class handles REST API requests, and that all methods should return data directly in the HTTP response body usually in JSON.
*
* Q3: What does the @GetMapping("/me") annotation do?
*   - It maps HTTP GET requests sent to the @GetMapping("/me") endpoint to a specific method in the controller.
*
* Q4: Why did you change from returning a String to a Map?
*    - Because it is more flexible, organized, and easier to extend.
*
* Q5: How does Spring Boot handle JSON responses automatically?
*    - Springboot uses a library like JSON to automatically convert java objects before sending them in the HTTP response.
*/


package com.dolormente.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Henry S. Dolormente");
        response.put("studentId", "2025-1023364");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}