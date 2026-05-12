package com.grasp.cantela.service.Implementation;

import com.grasp.cantela.dto.EmployeeRequestDTO;
import com.grasp.cantela.dto.EmployeeResponseDTO;
import com.grasp.cantela.Entity.Employee;
import com.grasp.cantela.Exception.ResourceNotFoundException;
import com.grasp.cantela.mapper.EmployeeMapper;
import com.grasp.cantela.repository.EmployeeRepository;
import com.grasp.cantela.service.EmployeeFactory;
import com.grasp.cantela.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
// GRASP: Pure Fabrication - Service layer created to encapsulate business logic (not a domain concept)
// GRASP: Low Coupling - Depends on interfaces (EmployeeRepository, EmployeeFactory) not concrete classes
// GRASP: High Cohesion - Single responsibility: employee business logic operations
// GRASP: Indirection - Repository interface acts as a layer between service and data access
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeFactory employeeFactory;

    //CREATE
    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
        Employee employee = employeeFactory.createEmp(dto);
        Employee save = employeeRepository.save(employee);

        return EmployeeMapper.toDTO(save);
    }

    //GET ALL EMPLOYEES
    @Override
    public List<EmployeeResponseDTO> getAllEmployees () {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    //GET BY ID
    @Override
    public EmployeeResponseDTO getEmployeeById (Long id) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        return EmployeeMapper.toDTO(emp);
    }

    //UPDATE
    @Override
    public EmployeeResponseDTO updateEmployee (Long id, EmployeeRequestDTO dto) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        emp.setName(dto.getName());
        emp.setPosition(dto.getPosition());
        emp.setDepartment(dto.getDepartment());
        emp.setEmail(dto.getEmail());
        emp.setMonthlySalary(dto.getMonthlySalary());

        Employee save = employeeRepository.save(emp);

        return EmployeeMapper.toDTO(save);

    }

    //DELETE
    @Override
    public void deleteEmployee (Long id) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        employeeRepository.deleteById(id);
    }

}
