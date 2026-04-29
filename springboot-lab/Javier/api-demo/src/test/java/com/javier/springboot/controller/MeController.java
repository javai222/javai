package com.javier.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeController {

    @GetMapping("/me")
    public String getMe() {
        return "Hello! I am Charles Justin Javier, a student learning Spring Boot!";
    }
}