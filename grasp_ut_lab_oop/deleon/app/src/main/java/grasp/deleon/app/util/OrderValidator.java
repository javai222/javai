package grasp.deleon.app.util;

import grasp.deleon.app.dto.OrderDTO;
import org.springframework.stereotype.Component;

// GRASP: Pure Fabrication - OrderValidator does not map to any real-world concept
//        It exists to give validation a dedicated home (High Cohesion)
// GRASP: High Cohesion - this class only does ONE thing: validate order input
@Component
public class OrderValidator {

    // Validates that a new order request has valid data
    public void validate(OrderDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Order data cannot be null");
        }
        if (dto.getCustomerName() == null || dto.getCustomerName().isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be blank");
        }
        if (dto.getItems() == null || dto.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
        for (OrderDTO.OrderItemDTO item : dto.getItems()) {
            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Item quantity must be greater than zero");
            }
            if (item.getUnitPrice() < 0) {
                throw new IllegalArgumentException("Item unit price cannot be negative");
            }
        }
    }
}
