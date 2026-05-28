package com.grasp.cantela.dto;

import lombok.Builder;
import lombok.Data;

// GRASP: Protected Variations - DTO shields entity from external API changes
// GRASP: High Cohesion - Single responsibility: carry employee response data
// OOP: DTO pattern — Response projection; hides persistence details from API consumers.
// YAGNI — No behavior on this type beyond data carriage (keeps response layer simple).
@Data
@Builder
public class EmployeeResponseDTO {
    private Long id;
    private String name;
    private String position;
    private String department;
    private String email;
    private double monthlySalary;

}
