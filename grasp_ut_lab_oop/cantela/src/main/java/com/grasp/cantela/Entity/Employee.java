package com.grasp.cantela.Entity;

import jakarta.persistence.*;
import lombok.*;
// GRASP: Information Expert - Employee has the data (monthlySalary), so it calculates its own yearly salary
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String position;
    private String department;
    private String email;
    private double monthlySalary;



    // GRASP: High Cohesion - Single responsibility: salary calculation within the entity
    public double calculateYearlySalary() {
        return this.monthlySalary * 12;
    }

}
