package com.silva.app.app_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deptName;
    private String deptLocation;
    private String managerName;
    private String contactNumber;
    private String contactEmail;

    public String getDeptName () {
        return deptName;
    }

    public String getDeptLocation () {
        return deptLocation;
    }

    public String getManagerName () {
        return managerName;
    }

    public String getContactNumber () {
        return contactNumber;
    }

    public String getContactEmail () {
        return contactEmail;
    }

    public void setDeptName (String deptName) {
        this.deptName = deptName;
    }

    public void setDeptLocation (String deptLocation) {
        this.deptLocation = deptLocation;
    }

    public void setManagerName (String managerName) {
        this.managerName = managerName;
    }

    public void setContactNumber (String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setContactEmail (String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
