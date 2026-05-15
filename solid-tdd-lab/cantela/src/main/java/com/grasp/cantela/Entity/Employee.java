package com.grasp.cantela.Entity;


import com.grasp.cantela.valueObject.SalarySnapshot;
import jakarta.persistence.*;
import lombok.*;
// GRASP: Information Expert - Employee has the data (monthlySalary), so it calculates its own yearly salary
// OOP: Composition over inheritance — persistence entity models “is an” employee record, not a subclass of a generic “Person”.
// SOLID: SRP — Entity focuses on employee data and salary rules tied to that data (not HTTP or persistence orchestration).
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
    // KISS — Straightforward domain rule kept next to the field it uses
    public double calculateYearlySalary() {
        return this.monthlySalary * 12;
    }

    // OOP: Immutability — Returns an immutable SalarySnapshot; callers cannot mutate entity state through this view.
    // Passes the monthly salary and yearly salary to snaphot
    public SalarySnapshot toSalarySnapshot () {
        return new SalarySnapshot(this.monthlySalary, this.calculateYearlySalary());
    }

}
