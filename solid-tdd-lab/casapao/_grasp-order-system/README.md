# GRASP + SOLID + Unit Testing Lab

## Project Overview
This project is a Spring Boot Order Management System developed as part of a software engineering lab. It demonstrates GRASP principles, SOLID design principles, and unit testing using JUnit 5 and Mockito.

The system allows creation and retrieval of orders while following clean architecture and maintainable design practices.

---

## Features
- Create new orders
- Retrieve all orders
- DTO-based request/response handling
- Validation layer
- Mapping layer
- Repository-based persistence (Spring Data JPA)

---

## Architecture Highlights

### Layered Structure
- Controller Layer (API endpoints)
- Service Layer (business logic)
- Repository Layer (data access)
- Utility Layer (validation)
- Mapper Layer (DTO conversion)

---

## SOLID Principles Applied

### 1. Single Responsibility Principle (SRP)
Each class has a single responsibility:
- `OrderService` → business logic only
- `OrderValidator` → input validation
- `OrderMapper` → object mapping
- `OrderRepository` → database access

---

### 2. Open-Closed Principle (OCP)
System is open for extension using new implementations without modifying existing code (e.g., new validators or mappers can be added).

---

### 3. Liskov Substitution Principle (LSP)
Repository and service abstractions allow interchangeable implementations without breaking functionality.

---

### 4. Interface Segregation Principle (ISP)
Small and focused interfaces are used instead of large, unnecessary ones.

---

### 5. Dependency Inversion Principle (DIP)
High-level modules depend on abstractions:
- `OrderService` depends on `OrderRepository`, `OrderValidator`, and `OrderMapper` abstractions instead of concrete implementations.

---

## OOP Best Practices Applied
- DRY (No duplicated logic)
- KISS (Simple service flow)
- Composition over inheritance
- Proper encapsulation
- DTO usage for separation of concerns

---

## Unit Testing

### Tools Used
- JUnit 5
- Mockito

### Test Coverage
- Service layer tested with mocked dependencies
- Repository interactions verified
- Edge cases included:
  - null input handling
  - empty lists
  - invalid requests

### Example Testing Approach
- Mock dependencies using `@Mock`
- Inject mocks using `@InjectMocks`
- Verify interactions using `Mockito.verify()`

---

## Example Test Types
- Order creation test
- Order retrieval test
- Validation failure test
- Exception handling test

---

## Project Structure

com.casapao.orders.app
├── controller
├── service
├── repository
├── dto
├── entity
├── mapper
├── util
└── exception


---

## How to Run

### Run application
```bash
./mvnw spring-boot:run
Run tests
./mvnw test
Refactoring Evidence

All improvements based on:

GRASP principles
SOLID principles
Separation of concerns
Testability improvements

Evidence files located in:

/refactoring-evidence/
Reflection

What improved the design the most?

Applying SRP significantly improved maintainability by separating validation, mapping, and business logic.

What bad design was removed?

Tight coupling between service logic and direct object creation was removed using dependency injection.

Hardest principle to apply?

OCP required careful thinking to avoid modifying existing logic while improving flexibility.