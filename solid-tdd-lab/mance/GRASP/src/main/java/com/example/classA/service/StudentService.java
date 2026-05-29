package com.example.classA.service;

import com.example.classA.entity.Student;
import com.example.classA.repository.StudentRepository;
import com.example.classA.validation.StudentValidationService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;
    private final StudentValidationService validator;

    public StudentService(StudentRepository repo, StudentValidationService validator) {
        this.repo = repo;
        this.validator = validator;
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }

    public Student save(Student student) {
        validator.validate(student);
        return repo.save(student);
    }
}