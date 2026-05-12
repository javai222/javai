package com.grasp.cantela.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// GRASP: Protected Variations - DTO shields entity from external API changes
// GRASP: High Cohesion - Single responsibility: carry employee creation data
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeRequestDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Position is required")
    @Size(min = 2, max = 50, message = "Position must be between 2 and 50 characters")
    private String position;

    @NotBlank(message = "Department is required")
    @Size(min = 2, max = 50, message = "Department must be between 2 and 50 characters")
    private String department;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Size(min = 5, max = 100, message = "Email must be between 5 and 100 characters")
    private String email;


    @Min(value = 0, message = "Monthly salary must be positive")
    private double monthlySalary;

}

