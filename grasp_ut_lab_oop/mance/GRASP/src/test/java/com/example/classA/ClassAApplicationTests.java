package com.example.classA;

import com.example.classA.entity.Student;
import com.example.classA.repository.StudentRepository;
import com.example.classA.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

	@Mock
	StudentRepository repo;

	@InjectMocks
    StudentService service;

	@Test
	void shouldSaveStudent() {

		Student student =
				new Student("John", "BSCS");

		service.save(student);

		verify(repo).save(student);
	}
}