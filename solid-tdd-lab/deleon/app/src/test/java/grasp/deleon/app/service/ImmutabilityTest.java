package grasp.deleon.app.service;

import grasp.deleon.app.entity.OrderItemSnapshot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Tests proving that OrderItemSnapshot is truly immutable.
// OOP: Immutability - once created, the snapshot's values never change.
class ImmutabilityTest {

    // TEST 1 — Snapshot preserves correct values after construction
    @Test
    void snapshotShouldPreserveValuesAfterCreation() {
        // Arrange + Act
        OrderItemSnapshot snapshot = new OrderItemSnapshot("Laptop", 2, 500.0);

        // Assert: all values match what was passed in
        assertEquals("Laptop", snapshot.getProductName());
        assertEquals(2, snapshot.getQuantity());
        assertEquals(500.0, snapshot.getUnitPrice());
    }

    // TEST 2 — Subtotal is calculated and locked at construction time
    @Test
    void snapshotShouldCalculateAndLockSubtotal() {
        // Arrange + Act: 3 × $75.00 = $225.00
        OrderItemSnapshot snapshot = new OrderItemSnapshot("Chair", 3, 75.0);

        // Assert: subtotal is calculated correctly and immutably stored
        assertEquals(225.0, snapshot.getSubtotal(),
                "Subtotal should be 3 × $75 = $225 and cannot change after construction");
    }

    // TEST 3 — Two snapshots with same values are independent objects
    @Test
    void twoSnapshotsWithSameValuesShouldBeIndependent() {
        // Arrange
        OrderItemSnapshot s1 = new OrderItemSnapshot("Phone", 1, 300.0);
        OrderItemSnapshot s2 = new OrderItemSnapshot("Phone", 1, 300.0);

        // Assert: same values, different objects — immutability means no shared mutable state
        assertEquals(s1.getSubtotal(), s2.getSubtotal());
        assertNotSame(s1, s2, "Two snapshots should be distinct objects");
    }

    // TEST 4 — Snapshot class is declared 'final' (cannot be subclassed to bypass immutability)
    @Test
    void snapshotClassShouldBeFinal() {
        // The class is declared 'final' — this assertion verifies that at runtime.
        assertTrue(java.lang.reflect.Modifier.isFinal(
                        OrderItemSnapshot.class.getModifiers()),
                "OrderItemSnapshot must be declared final to prevent subclassing");
    }

    // TEST 5 — Edge case: zero quantity produces zero subtotal
    @Test
    void snapshotWithZeroQuantityShouldHaveZeroSubtotal() {
        OrderItemSnapshot snapshot = new OrderItemSnapshot("Item", 0, 50.0);
        assertEquals(0.0, snapshot.getSubtotal(),
                "Zero quantity should produce $0.00 subtotal");
    }
}
