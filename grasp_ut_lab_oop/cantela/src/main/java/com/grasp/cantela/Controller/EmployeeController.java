package com.grasp.cantela.Controller;

import com.grasp.cantela.dto.EmployeeRequestDTO;
import com.grasp.cantela.dto.EmployeeResponseDTO;
import com.grasp.cantela.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
// GRASP: Controller - Handles HTTP requests and delegates to service layer
// GRASP: Low Coupling - Depends only on EmployeeService interface, not implementations
public class EmployeeController {

    private final EmployeeService employeeService;

    // GRASP: Protected Variations - Interface (EmployeeService) shields controller from implementation changes
    //CREATE
    @PostMapping("/create")
    public ResponseEntity<EmployeeResponseDTO> createEmployee (@RequestBody EmployeeRequestDTO dto) {
        return ResponseEntity.ok(employeeService.createEmployee(dto));
    }

    //GET ALL EMPLOYEES
    @GetMapping("/")
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees () {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    //GET EMPLOYEE BY ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getById (@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));

    }

    //UPDATE EMPLOYEE
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee (@PathVariable Long id, @Valid @RequestBody EmployeeRequestDTO dto) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, dto));
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee (@PathVariable Long id) {
        employeeService.deleteEmployee(id);

        return ResponseEntity.ok("Employee with id: " + id + " was deleted successfully");
    }
}
