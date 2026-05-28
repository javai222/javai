package com.silva.app.app_demo.service;

import com.silva.app.app_demo.entity.Department;
import com.silva.app.app_demo.exception.DepartmentNotFoundException;
import com.silva.app.app_demo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department newDepartment) {
        Department department = getDepartmentById(id);

        department.setDeptName(newDepartment.getDeptName());
        department.setDeptLocation(newDepartment.getDeptLocation());
        department.setManagerName(newDepartment.getManagerName());
        department.setContactNumber(newDepartment.getContactNumber());
        department.setContactEmail(newDepartment.getContactEmail());

        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        Department department = getDepartmentById(id);
        departmentRepository.delete(department);
    }
}