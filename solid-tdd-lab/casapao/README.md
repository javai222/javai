📦 Order Management System (SOLID + OOP Refactored) (AI helps create these)
🧾 Overview

This project is a Spring Boot-based Order Management System developed as part of a software engineering lab. It was originally built using GRASP principles and later refactored to apply SOLID principles, OOP best practices, and unit testing using JUnit 5 and Mockito.

The system supports order creation, retrieval, and polymorphic payment processing while maintaining a clean and scalable architecture.

🎯 Features
Create orders with multiple items
Retrieve all orders
Automatic calculation of order total
Polymorphic payment processing (Card, GCash, etc.)
Clean layered architecture (Controller → Service → Repository)
DTO-based responses for clean API design
🏗️ Tech Stack
Java 26
Spring Boot 3
Spring Data JPA
PostgreSQL
JUnit 5
Mockito
Maven
🧠 Architecture & Design Principles

This project was refactored to improve maintainability, scalability, and testability.

✔ SOLID Principles Applied
SRP (Single Responsibility Principle) – Each class handles one responsibility only
OCP (Open-Closed Principle) – System is open for extension (payment methods) but closed for modification
LSP (Liskov Substitution Principle) – Payment implementations are interchangeable
ISP (Interface Segregation Principle) – Interfaces are focused and minimal
DIP (Dependency Inversion Principle) – System depends on abstractions, not concrete classes
✔ OOP Best Practices Applied
DRY (Don’t Repeat Yourself)
KISS (Keep It Simple)
YAGNI (Avoid unnecessary features)
Composition over Inheritance
Proper use of DTOs
Clean separation of concerns
💳 Polymorphism Example

The system supports multiple payment methods using a common interface:

CardPayment
GCashPayment
PaymentService payment1 = new CardPayment();
PaymentService payment2 = new GCashPayment();

payment1.processPayment(100);
payment2.processPayment(100);

This allows the system to extend payment methods without modifying existing code.

🧪 Testing Strategy

The project uses:

JUnit 5 for unit testing
Mockito for mocking dependencies
Service-layer testing for business logic
Edge case testing
Interaction verification (verify repository/service calls)
🔬 Test Coverage Includes
✔ Service Layer Tests
Create order functionality
Retrieve all orders
Business logic validation
Repository interaction verification
✔ Edge Cases
Empty order list handling
Null or empty request handling
Missing item list safety
✔ Polymorphism Tests
CardPayment behavior validation
GCashPayment behavior validation
Interface-based execution verification
📁 Project Structure
src/main/java/com/casapao/orders/app/
 ├── controller/
 ├── service/
 │    ├── impl/
 │    │     ├── OrderServiceImpl
 │    │     ├── CardPayment
 │    │     ├── GCashPayment
 │    ├── PaymentService
 |    |── OrderService
 ├── repository/
 ├── entity/
 ├── dto/

src/test/java/com/casapao/orders/app/
 ├── service/
 │    ├── OrderServiceTest
 │    ├── PaymentServiceTest
🚀 How to Run the Project
1. Clone repository
git clone <your-repo-url>
2. Configure database

Update application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
spring.datasource.username=your_user
spring.datasource.password=your_password
3. Run application
mvn spring-boot:run
🧪 Run Tests
mvn test
📊 Key Improvements After Refactoring
Removed tight coupling between classes
Improved testability using dependency injection
Introduced polymorphism for payment system
Eliminated duplicated logic
Improved separation of concerns
Increased system scalability and flexibility
🧠 Reflection
✔ Which principle improved the design most?

The Dependency Inversion Principle (DIP) improved the design the most. It reduced coupling between layers and allowed the system to depend on abstractions rather than concrete implementations, making the code more flexible and testable.

✔ What bad design was removed?

The system previously had tight coupling and direct dependency on concrete classes, especially in the service layer. This made testing difficult and reduced flexibility. These issues were resolved using interfaces and dependency injection.

✔ Which principle was hardest to apply?

The Open-Closed Principle (OCP) was the hardest to apply because it required restructuring the payment system to support multiple implementations without modifying existing logic. This required careful use of interfaces and polymorphism.

📌 Future Improvements
Add Spring Security authentication
Add global exception handling
Add API documentation (Swagger)
Add integration testing
Improve validation layer
Add caching for performance optimization
👨‍💻 Author

Software Engineering Lab Project
Spring Boot + SOLID + Unit Testing Refactor