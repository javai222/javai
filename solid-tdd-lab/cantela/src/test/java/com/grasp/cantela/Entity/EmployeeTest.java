package com.grasp.cantela.Entity;


import com.grasp.cantela.valueObject.SalarySnapshot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// GRASP: Information Expert - Testing that Employee correctly calculates its own salary
// GRASP: High Cohesion - Single responsibility: test Entity behavior
// OOP: Immutability — Snapshot is a record; once produced, totals are stable for that value object instance.
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

    @Test
    void shouldToSalarySnapshot() {
        Employee employee = Employee.builder()
                .monthlySalary(4000)
                .build();

        SalarySnapshot first = employee.toSalarySnapshot();
        SalarySnapshot second = employee.toSalarySnapshot();

        assertEquals(48000, first.yearlySalary());
        assertEquals(first, second);
    }
}
