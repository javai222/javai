# SOLID + OOP Best Practices Lab - Plantilla

## Reused Project
GRASP + Unit Testing Lab - Plantilla

## What Was Refactored?

### SRP - Single Responsibility Principle
BEFORE: OrderService handled both validation AND business logic 

AFTER: Validation extracted to OrderValidator.java

### OCP - Open Closed Principle
Payment interface allows new payment types without modifying existing code.
Adding GCashPayment did not require changing OrderService.

### LSP - Liskov Substitution Principle
CashPayment, CreditCardPayment, GCashPayment all correctly implement Payment interface.
Any of them can replace Payment without breaking the system.

### ISP - Interface Segregation Principle
Payment interface only has 2 methods: process() and getPaymentType().
No class is forced to implement methods it does not need.

### DIP - Dependency Inversion Principle
BEFORE: OrderService could directly create payment objects

AFTER: OrderService depends on Payment interface via Map injection

## OOP Best Practices
- DRY: Validation logic centralized in OrderValidator
- KISS: Each class does one simple job
- YAGNI: No unused methods or classes added
- Composition Over Inheritance: OrderService HAS-A OrderValidator

## Test Results
- Total Tests: 13
- All Passing

## Reflection
- Hardest principle: DIP
- Best improvement: SRP - extracting the OrderValidator
- Bad design removed: validation mixed inside OrderService