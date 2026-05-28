package com.grasp.cantela.mapper;

import com.grasp.cantela.dto.EmployeeRequestDTO;
import com.grasp.cantela.dto.EmployeeResponseDTO;
import com.grasp.cantela.Entity.Employee;

// GRASP: Pure Fabrication - Artificial utility class for DTO conversion
// GRASP: High Cohesion - Single responsibility: converting between Entity and DTO objects
public class EmployeeMapper {

    // GRASP: Low Coupling - Static methods, no state or dependencies
    public static Employee toEntity (EmployeeRequestDTO dto) {
        return Employee.builder()
                .name(dto.getName())
                .position(dto.getPosition())
                .department(dto.getDepartment())
                .email(dto.getEmail())
                .monthlySalary(dto.getMonthlySalary())
                .build();
    }

    // GRASP: Low Coupling - Static methods, no state or dependencies
    public static EmployeeResponseDTO toDTO (Employee emp) {
        return EmployeeResponseDTO.builder()
                .id(emp.getId())
                .name(emp.getName())
                .position(emp.getPosition())
                .department(emp.getDepartment())
                .email(emp.getEmail())
                .monthlySalary(emp.getMonthlySalary())
                .build();
    }


}


