package com.silva.app.app_demo.repository;

import com.silva.app.app_demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    }

