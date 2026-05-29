package com.example.classA.service;

import com.example.classA.entity.Student;
import com.example.classA.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    // SOLID: DIP
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    // SOLID: SRP
    public List<Student> getStudents() {
        return repo.findAll();
    }

    public Student save(Student student) {
        return repo.save(student);
    }
}