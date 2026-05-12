package com.grasp.cantela.Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// GRASP: Information Expert - Testing that Employee correctly calculates its own salary
// GRASP: High Cohesion - Single responsibility: test Entity behavior
class EmployeeTest {

    @Test
    void shouldCalculateYearlySalary() {
        // Arrange
        Employee employee = Employee.builder()
                .id(1L)
                .name("Chris")
                .position("Developer")
                .department("IT")
                .email("chris@example.com")
                .monthlySalary(50000)
                .build();

        // Act
        double yearlySalary = employee.calculateYearlySalary();

        // Assert
        assertEquals(600000, yearlySalary);
    }
}
