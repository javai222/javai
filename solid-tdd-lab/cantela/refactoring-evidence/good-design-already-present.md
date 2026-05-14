# Good design already present (no change required)
# This md file is created by AI to identify and document good design areas. 

These areas already satisfied the lab checklist; code was **not** reworked, only documented with SOLID/OOP comments.

## Dependency inversion (DIP)

- `EmployeeController` depends on `EmployeeService` (interface), not `EmployeeServiceImpl`.
- `EmployeeServiceImpl` depends on `EmployeeRepository` and `EmployeeFactory` (interfaces / Spring Data port).
- **Why it is good:** high-level modules do not import low-level persistence or creation implementations directly.

## Interface segregation + polymorphism (ISP / OCP / LSP)

- `Payment` is a minimal interface (`processPayment` only). `CashPayment` and `BankTransferPayment` are small, substitutable strategies.
- **Why it is good:** no fat “god” payment API; new channels add a class instead of editing a long `if/else` chain.

## DTO + validation boundary

- `EmployeeRequestDTO` carries Jakarta Validation; `EmployeeResponseDTO` shapes responses.
- **Why it is good:** API contract stays separate from the JPA entity (DTO pattern), keeping persistence details off the wire.

## Custom exception

- `ResourceNotFoundException` signals missing aggregates clearly.
- **Why it is good:** callers and tests can distinguish “not found” from other failures without parsing generic exceptions.

## Package layout

- Split across `Controller`, `service`, `repository`, `dto`, `Entity`, `Exception`, `mapper`, `PaymentPoly`.
- **Why it is good:** responsibilities are discoverable by package, matching typical Spring layering.

## Composition over inheritance

- `EmployeeFactoryImpl` composes `Employee.builder()` rather than subclassing `Employee`.
- **Why it is good:** avoids fragile deep hierarchies for simple construction.
