package com.example.classA.validation;

import com.example.classA.entity.Student;
import org.springframework.stereotype.Service;

// SOLID: SRP - Handles validation only
@Service
public class StudentValidationService {

    public void validate(Student student) {

        if(student == null) {
            throw new IllegalArgumentException(
                    "Student is null"
            );
        }

        if(student.getName() == null ||
                student.getName().isEmpty()) {

            throw new IllegalArgumentException(
                    "Name is required"
            );
        }
    }
}