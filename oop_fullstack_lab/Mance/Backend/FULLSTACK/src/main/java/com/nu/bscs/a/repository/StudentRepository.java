package com.nu.bscs.a.repository;

import com.nu.bscs.a.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
