package com.grasp.cantela.service;

import com.grasp.cantela.dto.EmployeeRequestDTO;
import  com.grasp.cantela.Entity.Employee;

// GRASP: Creator - Responsible for creating Employee objects
// GRASP: Protected Variations - Interface allows different creation strategies
// GRASP: High Cohesion - Single responsibility: employee object creation
public interface EmployeeFactory {
    Employee createEmp(EmployeeRequestDTO dto);
}
