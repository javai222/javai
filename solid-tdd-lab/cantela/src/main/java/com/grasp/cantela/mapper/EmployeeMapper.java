package com.grasp.cantela.mapper;

import com.grasp.cantela.dto.EmployeeRequestDTO;
import com.grasp.cantela.dto.EmployeeResponseDTO;
import com.grasp.cantela.Entity.Employee;

// GRASP: Pure Fabrication - Artificial utility class for DTO conversion
// GRASP: High Cohesion - Single responsibility: converting between Entity and DTO objects
// SOLID: SRP — Mapping between persistence model and API DTOs only (no business branching).
// DRY: Shared reusable conversion helpers for entity/DTO boundaries (YAGNI: toEntity kept for non-factory flows).
public class EmployeeMapper {


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


