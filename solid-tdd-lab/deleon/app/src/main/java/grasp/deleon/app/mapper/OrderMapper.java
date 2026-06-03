package grasp.deleon.app.mapper;

import grasp.deleon.app.dto.OrderDTO;
import grasp.deleon.app.entity.Order;
import grasp.deleon.app.entity.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

// SOLID: SRP  - OrderMapper has ONE job: convert between Order entity and OrderDTO.
//               It does not validate, persist, or apply business logic.
// GRASP: Pure Fabrication - Mapper has no real-world equivalent. It exists purely
//               to keep the design clean and avoid duplication.
// DRY:         One central place for all Order <-> DTO conversion logic.
//               No other class needs to repeat this mapping code.
@Component
public class OrderMapper {

    // Converts a single Order entity into an OrderDTO for the API layer.
    // SOLID: SRP - this method does one thing only: map fields.
    public OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setCustomerName(order.getCustomerName());
        dto.setStatus(order.getStatus());
        dto.setCreatedAt(order.getCreatedAt());

        // GRASP: Information Expert - calculateTotal() is called on Order because
        //        Order is the class that owns the items list.
        dto.setTotal(order.calculateTotal());

        // Map each OrderItem to OrderItemDTO
        List<OrderDTO.OrderItemDTO> itemDTOs = order.getItems().stream()
                .map(this::toItemDTO)
                .collect(Collectors.toList());
        dto.setItems(itemDTOs);

        return dto;
    }

    // Converts a list of Order entities to a list of OrderDTOs.
    // DRY: Reuses toDTO() instead of duplicating mapping logic.
    public List<OrderDTO> toDTOList(List<Order> orders) {
        return orders.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Converts a single OrderItem entity to an OrderItemDTO.
    // SOLID: SRP - focused solely on item-level mapping.
    private OrderDTO.OrderItemDTO toItemDTO(OrderItem item) {
        return new OrderDTO.OrderItemDTO(
                item.getProductName(),
                item.getQuantity(),
                item.getUnitPrice()
        );
    }
}
