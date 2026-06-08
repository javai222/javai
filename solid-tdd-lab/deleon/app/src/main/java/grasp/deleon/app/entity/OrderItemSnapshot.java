package grasp.deleon.app.entity;

// OOP: Immutability - All fields are final. Once constructed, this object cannot change.
//      This is the correct use of immutability for value objects and audit records.
// SOLID: SRP - This class only represents a historical snapshot of an order item.
//              It does not validate, persist, or transform data.
// OOP: Encapsulation - All fields are private and final. No setters exist.
//      The only way to get values is through the provided getters.
// YAGNI: Only fields that are actually needed for a snapshot are included.
//         No extra fields "just in case."
// Design Pattern: Value Object - an immutable object defined by its values, not identity.
public final class OrderItemSnapshot {

    // 'final' means this field is set ONCE in the constructor and NEVER changed.
    private final String productName;
    private final int quantity;
    private final double unitPrice;
    private final double subtotal;

    // The only way to create an OrderItemSnapshot is through this constructor.
    // GRASP: Creator - this constructor receives all data it needs at construction time.
    public OrderItemSnapshot(String productName, int quantity, double unitPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        // GRASP: Information Expert - subtotal is calculated at construction time
        //        and locked in. It cannot drift from the original values.
        this.subtotal = quantity * unitPrice;
    }

    // Read-only access to the snapshot's values.
    // OOP: Encapsulation - fields are exposed safely through getters only.
    // NOTE: There are NO setters. This is intentional. Immutability requires no setters.
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getUnitPrice() { return unitPrice; }
    public double getSubtotal() { return subtotal; }
}
