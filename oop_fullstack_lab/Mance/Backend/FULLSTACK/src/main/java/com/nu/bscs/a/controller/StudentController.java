package com.nu.bscs.a.controller; // Make sure this matches the package folder structure in IntelliJ

import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5173") // Allows your VS Code Vite port to connect
public class StudentController {

    // This handles the request from your frontend and sends back the list of students
    @GetMapping
    public List<String> getAllStudents() {
        return Arrays.asList("John Roque", "Jane Doe", "Fayemaya");
    }
}