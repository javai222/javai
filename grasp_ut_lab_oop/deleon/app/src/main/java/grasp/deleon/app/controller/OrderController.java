package grasp.deleon.app.controller;

import grasp.deleon.app.dto.OrderDTO;
import grasp.deleon.app.entity.CashPayment;
import grasp.deleon.app.entity.CardPayment;
import grasp.deleon.app.entity.OrderStatus;
import grasp.deleon.app.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// GRASP: Controller - OrderController handles ALL incoming HTTP requests for orders
//        It does NOT contain business logic — it delegates everything to OrderService
// GRASP: Indirection - acts as entry point and hands off to the service layer
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    // GRASP: Low Coupling - depends on OrderService, not on the repository directly
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // POST /api/orders — Create a new order
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO dto) {
        OrderDTO created = orderService.createOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // GET /api/orders — Get all orders
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // GET /api/orders/{id} — Get one order by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    // PATCH /api/orders/{id}/status — Update order status
    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderDTO> updateStatus(
            @PathVariable Long id,
            @RequestParam OrderStatus status) {
        return ResponseEntity.ok(orderService.updateOrderStatus(id, status));
    }

    // DELETE /api/orders/{id} — Delete an order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    // POST /api/orders/{id}/pay/cash — Process cash payment
    // GRASP: Polymorphism - controller chooses which Payment implementation to use
    @PostMapping("/{id}/pay/cash")
    public ResponseEntity<String> payCash(@PathVariable Long id) {
        String result = orderService.processPayment(id, new CashPayment());
        return ResponseEntity.ok(result);
    }

    // POST /api/orders/{id}/pay/card — Process card payment
    @PostMapping("/{id}/pay/card")
    public ResponseEntity<String> payCard(
            @PathVariable Long id,
            @RequestParam String cardLastFour) {
        String result = orderService.processPayment(id, new CardPayment(cardLastFour));
        return ResponseEntity.ok(result);
    }
}
