package com.grasp.cantela.valueObject;

import com.grasp.cantela.Exception.NegativeAmountException;

/*
 * OOP: Immutability — Java record; components are final and cannot be reassigned after construction.
 * SOLID: SRP — Holds only a frozen view of monthly vs yearly salary figures.
 * KISS — Thin value type with validation in one place.
 * Holds monthly and yearly salary together, it also shows immutability
 */
public record SalarySnapshot(double monthlySalary, double yearlySalary) {

    // OOP: Immutability — compact constructor validates consistent state at creation time
    public SalarySnapshot {
        if (monthlySalary < 0) {
            throw new NegativeAmountException("Monthly salary cannot be negative");
        }
        if (yearlySalary < 0) {
            throw new NegativeAmountException("Yearly salary cannot be negative");
        }

    }
}
