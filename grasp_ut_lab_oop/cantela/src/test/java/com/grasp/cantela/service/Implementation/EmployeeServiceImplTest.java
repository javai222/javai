package com.grasp.cantela.service.Implementation;

import com.grasp.cantela.Entity.Employee;
import com.grasp.cantela.Exception.ResourceNotFoundException;
import com.grasp.cantela.dto.EmployeeRequestDTO;
import com.grasp.cantela.dto.EmployeeResponseDTO;
import com.grasp.cantela.repository.EmployeeRepository;
import com.grasp.cantela.service.EmployeeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
// GRASP: Low Coupling - Tests depend on interfaces (EmployeeService), not concrete implementations
// GRASP: High Cohesion - Single responsibility: test service layer behavior
class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeFactory employeeFactory;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private EmployeeRequestDTO requestDTO;
    private Employee employee;

    @BeforeEach
    void setUp () {
        requestDTO = EmployeeRequestDTO.builder()
                .name("Sean")
                .position("Student")
                .department("IT")
                .email("Sean@gmail.com")
                .monthlySalary(50000)
                .build();

        employee = Employee.builder()
                .name("Sean")
                .position("Student")
                .department("IT")
                .email("Sean@gmail.com")
                .monthlySalary(50000)
                .build();

    }

    @Test
    void shouldCreateEmployee() {
        //Arrange
        when(employeeFactory.createEmp(requestDTO)).thenReturn(employee);
        when(employeeRepository.save(employee)).thenReturn(employee);

        //Act
        EmployeeResponseDTO result = employeeService.createEmployee(requestDTO);

        //Assert
        assertNotNull(result);
        assertEquals(employee.getId(), result.getId());
        assertEquals(employee.getName(), result.getName());
        verify(employeeFactory).createEmp(requestDTO);
        verify(employeeRepository).save(employee);
    }

    @Test
    void shouldGetAllEmployees() {
    //Arrange
        List<Employee> employees = List.of(employee);
        when(employeeRepository.findAll()).thenReturn(employees);

        //Act
        List<EmployeeResponseDTO> result = employeeService.getAllEmployees();

        //Assert
        assertEquals(1, result.size());
        assertEquals("Sean", result.getFirst().getName());
        assertEquals("Student", result.getFirst().getPosition());
        verify(employeeRepository).findAll();

    }

    @Test
    void shouldThrowWhenEmployeeNotFound() {
        //Arrange
        when(employeeRepository.findById(67L)).thenReturn(Optional.empty());

        //Act
        ResourceNotFoundException rnfe = assertThrows(ResourceNotFoundException.class, () -> employeeService.getEmployeeById(67L));

        //Assert
        assertEquals("Employee not found with id: 67", rnfe.getMessage());
        verify(employeeRepository).findById(67L);

    }

    @Test
    void getEmployeeById() {
        //Arrange
        when(employeeRepository.findById(1L)).thenReturn(Optional.ofNullable(employee));

        //Act
        EmployeeResponseDTO result = employeeService.getEmployeeById(1L);

        //Assert
        assertNotNull(result);
        assertEquals("Sean", result.getName());
        verify(employeeRepository).findById(1L);
    }

    @Test
    void updateEmployee() {
        //Arrange
        EmployeeRequestDTO updateDTO = EmployeeRequestDTO.builder()
                .name("Nelson")
                .position("Junior Dev")
                .department("IT")
                .email("nelsonUpdated@gmail.com")
                .monthlySalary(45000)
                .build();

        when(employeeRepository.findById(1L)).thenReturn(Optional.ofNullable(employee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        //Act
        EmployeeResponseDTO result = employeeService.updateEmployee(1L, updateDTO);

        //Assert
        assertEquals("Nelson", result.getName());
        assertEquals("Junior Dev", result.getPosition());
        assertEquals("IT", result.getDepartment());
        assertEquals(45000, result.getMonthlySalary());

        verify(employeeRepository).findById(1L);
        verify(employeeRepository).save(any(Employee.class));

    }

    @Test
    void shouldDeleteEmployee() {
    //Arrange
        when(employeeRepository.findById(1L)).thenReturn(Optional.ofNullable(employee));
        doNothing().when(employeeRepository).deleteById(1L);

        //Act
        assertDoesNotThrow(() -> employeeService.deleteEmployee(1L));

        //Assert
        verify(employeeRepository).findById(1L);
        verify(employeeRepository).deleteById(1L);
    }

    @Test
    void shouldThrowOnDeleteWhenMissing() {
        //Arrange
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        //Act
        ResourceNotFoundException rnfe = assertThrows(ResourceNotFoundException.class, () -> employeeService.deleteEmployee(1L));

        //Assert
        assertEquals("Employee not found with id: 1", rnfe.getMessage());
        verify(employeeRepository).findById(1L);

    }
}