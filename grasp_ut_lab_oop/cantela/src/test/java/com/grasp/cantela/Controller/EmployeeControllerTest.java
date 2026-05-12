package com.grasp.cantela.Controller;

import com.grasp.cantela.Entity.Employee;
import com.grasp.cantela.dto.EmployeeRequestDTO;
import com.grasp.cantela.dto.EmployeeResponseDTO;
import com.grasp.cantela.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(EmployeeController.class)
// GRASP: Low Coupling - Tests mock service dependencies, not real implementations
// GRASP: Protected Variations - Tests verify API contract, not implementation details
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;                     // provided by @WebMvcTest

    @Autowired
    private ObjectMapper mapper;

    @MockitoBean
    private EmployeeService employeeService;


    @Test
    void shouldCreateEmployee() throws Exception {
        //Arrange
        EmployeeRequestDTO request = EmployeeRequestDTO.builder()
                .name("Nelson")
                .position("Brainrot")
                .department("Exec")
                .email("nelson@example.com")
                .monthlySalary(696700)
                .build();

        EmployeeResponseDTO response = EmployeeResponseDTO.builder()
                .id(1L)
                .name("Nelson")
                .position("Brainrot")
                .department("Exec")
                .email("nelson@example.com")
                .monthlySalary(696700)
                .build();

        when(employeeService.createEmployee(request)).thenReturn(response);

        //Act and Assert
        mockMvc.perform(post("/api/employee/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Nelson"));

        verify(employeeService).createEmployee(any(EmployeeRequestDTO.class));
    }

    @Test
    void shouldGetAllEmployees() throws Exception {
        //Arrange
        List<EmployeeResponseDTO> list = List.of(
                EmployeeResponseDTO.builder()
                        .id(1L)
                        .name("Invincible")
                        .position("Viltrum Emperor")
                        .department("Executive")
                        .email("mark@example.com")
                        .monthlySalary(69000)
                        .build()
        );

        //Act
        when(employeeService.getAllEmployees()).thenReturn(list);

         //Assert
        mockMvc.perform(get("/api/employee/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Invincible"));

        verify(employeeService).getAllEmployees();
    }

    @Test
    void shouldGetById() throws Exception {
        //Arrange
        EmployeeResponseDTO responseDTO = EmployeeResponseDTO.builder()
                .id(1L)
                .name("Dexter")
                .position("Forensic Investigator")
                .department("Forensic")
                .email("dexter@example.com")
                .monthlySalary(50000)
                .build();

        //Act and Assert
        when(employeeService.getEmployeeById(1L)).thenReturn(responseDTO);

        mockMvc.perform(get("/api/employee/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Dexter"));
    }

    @Test
    void shouldUpdateEmployee() throws Exception {
        //Arrange
        EmployeeRequestDTO requestDTO = EmployeeRequestDTO.builder()
                .name("Barry")
                .position("speedster")
                .department("Justice League")
                .email("flash@example.com")
                .monthlySalary(10000)
                .build();

        EmployeeResponseDTO responseDTO = EmployeeResponseDTO.builder()
                .id(1L)
                .name("Barry")
                .position("speedster")
                .department("Justice League")
                .email("flash@example.com")
                .monthlySalary(10000)
                .build();

        //Act
        when(employeeService.updateEmployee(1L, requestDTO)).thenReturn(responseDTO);

        //Assert
        mockMvc.perform(put("/api/employee/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Barry"));

        verify(employeeService).updateEmployee(any(Long.class), any(EmployeeRequestDTO.class));

    }

    @Test
    void shouldDeleteEmployee() throws Exception {
        //Arrange
        doNothing().when(employeeService).deleteEmployee(3L);

        //Act and Assert
        mockMvc.perform(delete("/api/employee/delete/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("Employee with id: 3 was deleted successfully"));

        verify(employeeService).deleteEmployee(3L);
    }
}