package grasp.deleon.app.service;

import grasp.deleon.app.dto.OrderDTO;
import grasp.deleon.app.entity.OrderStatus;
import grasp.deleon.app.entity.Payment;

// SOLID: ISP - OrderCommandService is a focused interface containing ONLY write operations.
//              Read-only consumers (e.g. reporting tools) depend on OrderQueryService only.
// SOLID: OCP - New write operations can be added to this interface and implemented
//              in OrderServiceImpl without changing existing behavior.
// GRASP: Protected Variations - shields callers from knowing how writes are performed.
public interface OrderCommandService {

    // Creates a brand-new order from the given DTO.
    // Returns the saved order as a DTO with its generated ID.
    OrderDTO createOrder(OrderDTO dto);

    // Updates the status of an existing order.
    // Throws OrderNotFoundException if the order does not exist.
    OrderDTO updateOrderStatus(Long id, OrderStatus status);

    // Permanently deletes an order by its ID.
    // Throws OrderNotFoundException if the order does not exist.
    void deleteOrder(Long id);

    // Processes a payment for a specific order using any Payment implementation.
    // SOLID: OCP + DIP - accepts any Payment implementation without changing this interface.
    String processPayment(Long id, Payment payment);
}
