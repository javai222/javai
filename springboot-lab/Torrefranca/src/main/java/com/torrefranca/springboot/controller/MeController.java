package com.torrefranca.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MeController {

    //TEST1
//    @GetMapping("/me")
//    public String getMe() {
//        return "Hello! I am Vincent Torrefranca, a student learning Spring Boot!";
//    }

    @GetMapping("/me")
    public Map<String, Object> getMe() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", "Vincent Christopher P. Torrefranca");
        response.put("studentId", "2025-1029269");
        response.put("course", "Java Programming");
        response.put("message", "Learning Spring Boot REST APIs!");
        return response;
    }
}
