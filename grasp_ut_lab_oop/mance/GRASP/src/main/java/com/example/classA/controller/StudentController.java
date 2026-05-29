package com.example.classA.controller;

import com.example.classA.entity.Student;
import com.example.classA.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(service.getStudents());
    }

    @PostMapping
    public ResponseEntity<Student> save(
            @RequestBody Student student) {

        return ResponseEntity.ok(
                service.save(student)
        );
    }
}