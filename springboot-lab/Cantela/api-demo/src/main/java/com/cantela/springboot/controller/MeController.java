//Created by Cantela, Chris Nelson B.

// REST controller for handling /me endpoint requests

package com.cantela.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// Marks this class as a REST controller
@RestController
public class MeController {

    // Maps GET requests to /me and returns JSON response
    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();

        // Add user details to the response map
        response.put("name", "Chris Nelson Cantela");
        response.put("studentId", "2025-1020643");
        response.put("course", "Java Programming");
        response.put("message", "Leaning Spring Boot Rest APIs!");

        return response;
    }


}
