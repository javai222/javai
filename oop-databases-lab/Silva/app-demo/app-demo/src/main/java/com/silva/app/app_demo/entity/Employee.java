package com.silva.app.app_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstName;
    private String lastName;
    private String emDepartment;
    private String emPosition;
    private Double emSalary;


    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public String getEmDepartment () {
        return emDepartment;
    }

    public String getEmPosition () {
        return emPosition;
    }

    public Double getEmSalary () {
        return emSalary;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public void setEmDepartment (String emDepartment) {
        this.emDepartment = emDepartment;
    }

    public void setEmPosition (String emPosition) {
        this.emPosition = emPosition;
    }

    public void setEmSalary (Double emSalary) {
        this.emSalary = emSalary;
    }
}
