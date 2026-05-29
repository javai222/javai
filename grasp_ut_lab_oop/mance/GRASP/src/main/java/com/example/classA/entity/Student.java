package com.example.classA.entity;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String section;

    public Student() {}

    public Student(String name, String section) {
        this.name = name;
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSection() {
        return section;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSection(String section) {
        this.section = section;
    }
}