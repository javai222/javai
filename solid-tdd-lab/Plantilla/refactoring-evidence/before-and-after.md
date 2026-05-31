# Refactoring Evidence - Plantilla

---

## 1. SRP - Single Responsibility Principle

### BEFORE (Bad Design)
OrderService had validateItem() and validateCustomerName()
mixed together with business logic.
One class was doing too many things.

### AFTER (Good Design)
All validation moved to OrderValidator.java
OrderService now only handles business logic.

---

## 2. OCP - Open Closed Principle

### BEFORE (Bad Design)
To add a new payment type you had to modify OrderService.
The processPayment() method needed a new if-else block.

### AFTER (Good Design)
New payment type only needs a new class implementing Payment interface.
OrderService never needs to change.

---

## 3. DIP - Dependency Inversion Principle

### ALREADY GOOD DESIGN
OrderService depends on Payment interface via Map injection.
It never directly creates CashPayment or GCashPayment objects.

---

## 4. LSP - Liskov Substitution Principle

### ALREADY GOOD DESIGN
CashPayment, CreditCardPayment, GCashPayment all implement Payment interface.
Any of them can replace Payment without breaking the system.

---

## 5. ISP - Interface Segregation Principle

### ALREADY GOOD DESIGN
Payment interface only has 2 methods.
No class is forced to implement methods it does not need.

---

## 6. DRY - Don't Repeat Yourself

### BEFORE (Bad Design)
Validation logic was repeated inside OrderService methods.

### AFTER (Good Design)
All validation centralized in OrderValidator.java
Used by OrderService via validateRequest() method.

---

## 7. Composition Over Inheritance

### GOOD DESIGN
OrderService HAS-A OrderValidator instead of extending a base class.

---

## 8. Test Results
- Total Tests: 13
- All Passing