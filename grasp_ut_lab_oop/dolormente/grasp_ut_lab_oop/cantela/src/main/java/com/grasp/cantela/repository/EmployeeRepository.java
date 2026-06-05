package com.grasp.cantela.repository;

import com.grasp.cantela.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// GRASP: Repository (Indirection) - Acts as a layer between service and database
// GRASP: Protected Variations - Interface shields service from persistence technology changes
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}