package com.example.classA.controller;

import com.example.classA.entity.Student;
import com.example.classA.service.StudentService;
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
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return service.save(student);
    }
}