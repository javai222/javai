package com.grasp.cantela.integration;

import com.grasp.cantela.dto.EmployeeRequestDTO;
import com.grasp.cantela.dto.EmployeeResponseDTO;
import com.grasp.cantela.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Bonus: integration slice through service + persistence with in-memory H2 (no mocks for repositories).
 * Verifies components wired by Spring (DIP) cooperate end-to-end.
 */
@SpringBootTest
@Transactional
class EmployeeCrudIntegrationTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void shouldCreateEmployeeThenGetById() {
        EmployeeRequestDTO body = EmployeeRequestDTO.builder()
                .name("Chris Integ")
                .position("Call Center")
                .department("Customer Service")
                .email("ChrisNU@gmail.com")
                .monthlySalary(25000)
                .build();

        EmployeeResponseDTO created = employeeService.createEmployee(body);
        assertNotNull(created.getId());

        EmployeeResponseDTO fetched = employeeService.getEmployeeById(created.getId());
        assertEquals("ChrisNU@gmail.com", fetched.getEmail());
        assertEquals("Chris Integ", fetched.getName());
    }
}
