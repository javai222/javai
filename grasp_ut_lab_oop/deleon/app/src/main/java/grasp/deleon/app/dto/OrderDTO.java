package grasp.deleon.app.dto;

import grasp.deleon.app.entity.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;

// GRASP: Low Coupling - DTO separates the API layer from the entity layer
// GRASP: Pure Fabrication - OrderDTO has no real-world counterpart; it exists purely
//        to carry data cleanly between controller and service
public class OrderDTO {

    private Long id;
    private String customerName;
    private OrderStatus status;
    private LocalDateTime createdAt;
    private double total;
    private List<OrderItemDTO> items;

    // ---- Inner DTO for OrderItem ----
    public static class OrderItemDTO {
        private String productName;
        private int quantity;
        private double unitPrice;

        public OrderItemDTO() {}

        public OrderItemDTO(String productName, int quantity, double unitPrice) {
            this.productName = productName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }

        public double getUnitPrice() { return unitPrice; }
        public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
    }

    // ---- Constructors ----

    public OrderDTO() {}

    // ---- Getters and Setters ----

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public List<OrderItemDTO> getItems() { return items; }
    public void setItems(List<OrderItemDTO> items) { this.items = items; }
}
