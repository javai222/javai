package com.nu.bscs.a.service;

import com.nu.bscs.a.model.Student;
import com.nu.bscs.a.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(String fullName, String course) {
        return studentRepository.save(Student.builder().fullName(fullName)
                .course(course).build());
    }
}
