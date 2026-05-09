//author: Ryan James M. Balanon

/*
HOW DID YOU CREATE YOUR SPRING BOOT PROJECT?
I used Spring Initializr to quickly generate the project with the needed setup and dependencies.

WHAT IS THE PURPOSE OF @RestController?
It makes the class a REST API controller and returns data (like JSON) instead of a webpage.

WHAT DOES @GetMapping("/me") DO?
It handles GET requests to "/me" and runs the method when that URL is accessed.

WHY CHANGE FROM STRING TO MAP?
A Map allows structured data, which can be converted into JSON for API responses.

HOW DOES SPRING BOOT HANDLE JSON AUTOMATICALLY?
Spring Boot uses Jackson to convert Java objects (like Map) into JSON automatically.
*/


package com.balanon.api.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.HashMap;


@RestController
public class MeController {

    @GetMapping("/me")
    public String getMe() {

        Map<String, Object> response = new HashMap<>();

        response.put("name", "Ryan James M. Balanon");
        response.put("studentId", "2025-1028936");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");

        return response.toString();
    }
}
