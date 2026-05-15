package com.grasp.cantela.repository;

import com.grasp.cantela.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// GRASP: Repository (Indirection) - Acts as a layer between service and database
// GRASP: Protected Variations - Interface shields service from persistence technology changes
// SOLID: DIP — Domain services depend on this Spring Data port, not JDBC or vendor APIs.
// SOLID: ISP — Spring Data aggregate interface is inherited; application code depends only on this repository type.
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}