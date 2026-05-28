package com.deleon.springboot.controller;

/*
1. How did you create your Spring Boot project?
I created the project using Spring Initializr and with the help of AI

2. What is the purpose of the @RestController annotation?
@RestController tells Spring Boot that the class handles REST API requests and returns data directly.

3. What does the @GetMapping("/me") annotation do?
It connects the /me URL to the getMe() method using an HTTP GET request.

4. Why did you change from returning a String to a Map?
To return JSON data instead of plain text.

5. How does Spring Boot handle JSON responses automatically?
Spring Boot automatically converts Java objects into JSON using the Jackson library.

*/

/*
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeController {

    @GetMapping("/me")
    public String getMe() {
        return "Hello! I am Lord Ulrick A. De Leon, a student learning Spring Boot!";
    }
}
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
        response.put("name", "Lord Ulrick A. De Leon");
        response.put("studentId", "2025-1025177");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}