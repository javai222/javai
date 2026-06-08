package grasp.deleon.app.controller;

import grasp.deleon.app.dto.OrderDTO;
import grasp.deleon.app.entity.CashPayment;
import grasp.deleon.app.entity.CardPayment;
import grasp.deleon.app.entity.GCashPayment;
import grasp.deleon.app.entity.OrderStatus;
import grasp.deleon.app.service.OrderCommandService;
import grasp.deleon.app.service.OrderQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// SOLID: DIP  - OrderController depends on OrderQueryService and OrderCommandService
//               INTERFACES, not on OrderServiceImpl (the concrete class).
//               Spring injects the correct implementation automatically.
// SOLID: SRP  - Controller only handles HTTP concerns. All business logic is in the service.
// SOLID: ISP  - Controller uses two focused interfaces rather than one fat class.
// GRASP: Controller - Handles all HTTP requests for orders and delegates to service.
// GRASP: Low Coupling - No direct dependency on any repository or concrete service.
// OOP: Abstraction - The controller doesn't know whether OrderServiceImpl or any other
//                    class is running behind the interface. It only sees the interface.
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    // SOLID: DIP - Both fields are interface types. The concrete implementation
    //              (OrderServiceImpl) is injected by Spring at runtime.
    private final OrderQueryService queryService;
    private final OrderCommandService commandService;

    // Constructor injection — Spring resolves OrderServiceImpl as the implementation
    // for both interfaces automatically because it implements both.
    public OrderController(OrderQueryService queryService,
                           OrderCommandService commandService) {
        this.queryService = queryService;
        this.commandService = commandService;
    }

    // POST /api/orders — Create a new order
    // SOLID: ISP - Uses commandService (write interface only)
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO dto) {
        OrderDTO created = commandService.createOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // GET /api/orders — Retrieve all orders
    // SOLID: ISP - Uses queryService (read interface only)
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(queryService.getAllOrders());
    }

    // GET /api/orders/{id} — Retrieve one order by ID
    // SOLID: ISP - Uses queryService (read interface only)
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(queryService.getOrderById(id));
    }

    // PATCH /api/orders/{id}/status — Update order status
    // SOLID: ISP - Uses commandService (write interface only)
    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderDTO> updateStatus(
            @PathVariable Long id,
            @RequestParam OrderStatus status) {
        return ResponseEntity.ok(commandService.updateOrderStatus(id, status));
    }

    // DELETE /api/orders/{id} — Delete an order
    // SOLID: ISP - Uses commandService (write interface only)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        commandService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    // POST /api/orders/{id}/pay/cash — Cash payment
    // SOLID: OCP - Adding GCash did not change this method.
    // GRASP: Polymorphism - CashPayment is passed as a Payment interface
    @PostMapping("/{id}/pay/cash")
    public ResponseEntity<String> payCash(@PathVariable Long id) {
        return ResponseEntity.ok(commandService.processPayment(id, new CashPayment()));
    }

    // POST /api/orders/{id}/pay/card — Card payment
    @PostMapping("/{id}/pay/card")
    public ResponseEntity<String> payCard(
            @PathVariable Long id,
            @RequestParam String cardLastFour) {
        return ResponseEntity.ok(commandService.processPayment(id, new CardPayment(cardLastFour)));
    }

    // POST /api/orders/{id}/pay/gcash — GCash payment (NEW — added via OCP, zero changes elsewhere)
    // SOLID: OCP - This endpoint was ADDED. No existing endpoint or service was modified.
    // SOLID: LSP - GCashPayment substitutes Payment exactly like Cash and Card do.
    @PostMapping("/{id}/pay/gcash")
    public ResponseEntity<String> payGCash(
            @PathVariable Long id,
            @RequestParam String mobileNumber) {
        return ResponseEntity.ok(commandService.processPayment(id, new GCashPayment(mobileNumber)));
    }
}