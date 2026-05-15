package com.grasp.cantela.service.Implementation;

import com.grasp.cantela.Entity.Employee;
import com.grasp.cantela.dto.EmployeeRequestDTO;
import com.grasp.cantela.service.EmployeeFactory;
import org.springframework.stereotype.Service;

@Service
// GRASP: Creator - Creates Employee objects from DTOs
// GRASP: Pure Fabrication - Artificial class to encapsulate object creation logic
public class EmployeeFactoryImpl implements EmployeeFactory {
    // GRASP: Low Coupling - Uses builder pattern to create objects
    // GRASP: High Cohesion - Single responsibility: transforming DTO to Entity
    @Override
   public Employee createEmp (EmployeeRequestDTO dto) {
        return Employee.builder()
                .name(dto.getName())
                .position(dto.getPosition())
                .department(dto.getDepartment())
                .email(dto.getEmail())
                .monthlySalary(dto.getMonthlySalary())
                .build();
    }

}
