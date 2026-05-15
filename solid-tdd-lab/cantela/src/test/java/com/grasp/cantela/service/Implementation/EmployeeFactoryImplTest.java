package com.grasp.cantela.service.Implementation;

import com.grasp.cantela.Entity.Employee;
import com.grasp.cantela.dto.EmployeeRequestDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// GRASP: Creator - Testing that factory correctly creates Employee objects
// GRASP: High Cohesion - Single responsibility: test factory creation behavior
// SOLID: SRP — Validates only factory mapping rules; persistence is out of scope here.
class EmployeeFactoryImplTest {

    @Test
    void shouldCreateEmployeeFromDTO() {
        // Arrange
        EmployeeRequestDTO dto = EmployeeRequestDTO.builder()
                .name("Chris")
                .position("Junior Dev")
                .department("IT")
                .email("chris@example.com")
                .monthlySalary(50000)
                .build();

        EmployeeFactoryImpl factory = new EmployeeFactoryImpl();

        // Act
        Employee employee = factory.createEmp(dto);

        // Assert
        assertNotNull(employee);
        assertEquals("Chris", employee.getName());
        assertEquals("Junior Dev", employee.getPosition());
        assertEquals("IT", employee.getDepartment());
        assertEquals("chris@example.com", employee.getEmail());
        assertEquals(50000, employee.getMonthlySalary());
    }
}
