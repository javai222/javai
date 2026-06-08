# SOLID + OOP Refactoring Lab
## Orders Management System

**Student:** Lord Ulrick A. De Leon

**Branch:** solid-refactor-ut-deleon

---

## Project Overview

This project demonstrates:
- All 9 GRASP principles (from Lab 1)
- All 5 SOLID principles (this lab)
- OOP best practices: DRY, KISS, YAGNI, Composition over Inheritance, Immutability
- Design Patterns: Strategy, Factory Method, Repository, DTO, Template Method

---

## Key Refactoring Decisions

### 1. Extracted OrderMapper (SRP)
**Before:** `OrderService` contained entity-to-DTO mapping logic mixed with business logic.
**After:** `OrderMapper` is a dedicated component with one job — map `Order` to `OrderDTO`.

### 2. Split OrderService into two interfaces (ISP)
**Before:** One large `OrderService` class with all operations.
**After:** `OrderQueryService` (reads) + `OrderCommandService` (writes). Consumers depend only on what they need.

### 3. Controller depends on interfaces, not concrete class (DIP)
**Before:** `OrderController` depended on `OrderService` (concrete).
**After:** `OrderController` depends on `OrderQueryService` and `OrderCommandService` (interfaces).

### 4. Added GCashPayment without touching existing code (OCP)
**Before:** Two payment types (Cash, Card).
**After:** Three payment types (Cash, Card, GCash). Zero changes to `OrderService` or `Payment` interface.

### 5. Immutable OrderItemSnapshot (Immutability)
**Before:** No immutable value objects existed.
**After:** `OrderItemSnapshot` uses all-final fields with no setters.

---

## How to Run

### Start Application