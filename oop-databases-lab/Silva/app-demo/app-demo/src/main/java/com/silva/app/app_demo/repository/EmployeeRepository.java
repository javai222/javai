package com.silva.app.app_demo.repository;

import com.silva.app.app_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    }

