package grasp.deleon.app.service;

// SOLID: OCP  - BaseOrderService defines a stable base. Subclasses extend behavior
//               without modifying this class.
// SOLID: SRP  - This class has one purpose: provide shared logging/auditing behavior
//               that all service implementations inherit.
// OOP: Inheritance - OrderServiceImpl inherits logOperation() from this class.
// Design Pattern: Template Method - defines a skeleton method (logOperation) that
//               subclasses can use without reimplementing it.
// GRASP: High Cohesion - contains only the shared cross-cutting concerns (logging).
public abstract class BaseOrderService {

    // Template Method: logs what operation is being performed and on which entity.
    // All subclasses call this to record their actions consistently.
    // DRY: One shared logging method. No subclass needs to duplicate logging logic.
    protected void logOperation(String operation, Long entityId) {
        System.out.println("[ORDER SERVICE] Operation: " + operation
                + " | Entity ID: " + (entityId != null ? entityId : "NEW"));
    }
}
