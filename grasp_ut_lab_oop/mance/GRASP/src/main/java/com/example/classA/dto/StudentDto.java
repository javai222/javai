package com.example.classA.dto;

public class StudentDto {

    private String name;
    private String section;

    public StudentDto() {}

    public StudentDto(String name, String section) {
        this.name = name;
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public String getSection() {
        return section;
    }
}