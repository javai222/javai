package com.example.classA.service;

import com.example.classA.entity.Student;
import com.example.classA.repository.StudentRepository;
import com.example.classA.validation.StudentValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository repo;

    @Mock
    private StudentValidationService validator;

    @InjectMocks
    private StudentService service;

    @Test
    void shouldSaveStudentSuccessfully() {
        Student student = new Student("John Roque", "BSCS");

        doNothing().when(validator).validate(any(Student.class));

        service.save(student);

        verify(repo, times(1)).save(student);
    }

    @Test
    void shouldThrowExceptionWhenStudentIsNull() {
        doThrow(new IllegalArgumentException("Student cannot be null"))
                .when(validator).validate(null);

        assertThrows(IllegalArgumentException.class, () -> {
            service.save(null);
        });
    }
}