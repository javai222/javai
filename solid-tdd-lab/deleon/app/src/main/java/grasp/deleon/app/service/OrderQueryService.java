package grasp.deleon.app.service;

import grasp.deleon.app.dto.OrderDTO;

import java.util.List;

// SOLID: ISP - OrderQueryService is a focused interface containing ONLY read operations.
//              Implementations are not forced to implement write methods they don't need.
// SOLID: DIP - Controllers depend on this interface, not on the concrete implementation.
// GRASP: Protected Variations - if query logic changes, only the implementation changes.
public interface OrderQueryService {

    // Retrieves all orders in the system.
    List<OrderDTO> getAllOrders();

    // Retrieves a single order by its unique ID.
    // Throws OrderNotFoundException if no order exists with that ID.
    OrderDTO getOrderById(Long id);
}
