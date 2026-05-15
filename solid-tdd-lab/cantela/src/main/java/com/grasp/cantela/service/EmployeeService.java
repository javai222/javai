package com.grasp.cantela.service;

import com.grasp.cantela.dto.EmployeeRequestDTO;
import com.grasp.cantela.dto.EmployeeResponseDTO;

import java.util.List;

// GRASP: Controller - Defines business operation contract for employee management
// GRASP: Protected Variations - Interface allows multiple implementations without affecting clients
// GRASP: High Cohesion - Single responsibility: defines employee business operations
// SOLID: ISP — Small, client-focused surface (employee CRUD only); no unrelated operations forced on implementers.
// SOLID: DIP — Controllers and tests depend on this contract instead of concrete service classes.
public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto);
    EmployeeResponseDTO getEmployeeById (Long id);
    List<EmployeeResponseDTO> getAllEmployees();
    EmployeeResponseDTO updateEmployee (Long id, EmployeeRequestDTO dto);
    void deleteEmployee (Long id);
}
