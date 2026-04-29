/* 
Created by Yvette Tismo
* How did you create your Spring Boot project?
    - I created my project with the help of Spring Initializr, Intellij/codespace, and AI

* What is the purpose of the @RestController annotation?
    - It tells spring that HTTP requests and that the return values of its methods should be automatically converted into JSON and sent in the HTTP response body.

* What does the @GetMapping("/me") annotation do?
    - @GetMapping("/me") maps HTTP GET requests sent to the /me endpoint to a specific method in the controller.

* Why did you change from returning a String to a Map?
    - So that it is more flexible, organized and prettier

* How does Spring Boot handle JSON responses automatically?
    - Spring Boot uses a library like Jackson to automatically convert Java objects

*/


package com.tismo.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Yvette Germaine E. Tismo");
        response.put("studentId", "2025-1027104");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}