package grasp.deleon.app.service;

import grasp.deleon.app.dto.OrderDTO;
import grasp.deleon.app.entity.*;
import grasp.deleon.app.mapper.OrderMapper;
import grasp.deleon.app.repository.OrderRepository;
import grasp.deleon.app.service.impl.OrderServiceImpl;
import grasp.deleon.app.util.OrderNotFoundException;
import grasp.deleon.app.util.OrderValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// SOLID: DIP proven in test - we mock INTERFACES (OrderRepository, OrderQueryService),
//        not concrete classes. The test never touches a real database.
// SOLID: SRP - This test class only tests OrderServiceImpl behavior.
// TDD: Each test follows Arrange → Act → Assert (AAA pattern).
@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    // SOLID: DIP - We mock the Repository interface, not a concrete DB class.
    @Mock
    private OrderRepository orderRepository;

    // SOLID: SRP - Validator is mocked; its behavior is tested in its own test class.
    @Mock
    private OrderValidator orderValidator;

    // OrderMapper is a simple component — we use the real one here for integration realism.
    // This also demonstrates Composition Over Inheritance: OrderServiceImpl HAS-A mapper.
    private OrderMapper orderMapper;

    // The real class being tested — Mockito injects all @Mock objects into it.
    @InjectMocks
    private OrderServiceImpl orderService;

    private Order sampleOrder;
    private OrderDTO sampleDTO;

    @BeforeEach
    void setUp() {
        // Instantiate the real mapper (no DB needed, pure mapping logic)
        orderMapper = new OrderMapper();

        // Rebuild OrderServiceImpl with the real mapper injected
        orderService = new OrderServiceImpl(orderRepository, orderValidator, orderMapper);

        // Build reusable test Order entity
        sampleOrder = new Order();
        sampleOrder.setId(1L);
        sampleOrder.setCustomerName("Alice");
        sampleOrder.setStatus(OrderStatus.PENDING);
        sampleOrder.setCreatedAt(LocalDateTime.now());

        OrderItem item = new OrderItem("Laptop", 2, 500.0);
        sampleOrder.setItems(new ArrayList<>(List.of(item)));

        // Build reusable test DTO
        sampleDTO = new OrderDTO();
        sampleDTO.setCustomerName("Alice");
        sampleDTO.setItems(List.of(new OrderDTO.OrderItemDTO("Laptop", 2, 500.0)));
    }

    // ---- SERVICE LAYER TESTS ----

    // TEST 1 — SRP: createOrder delegates validation and mapping correctly
    @Test
    void shouldCreateOrder() {
        // Arrange
        when(orderRepository.save(any(Order.class))).thenReturn(sampleOrder);
        doNothing().when(orderValidator).validate(any(OrderDTO.class));

        // Act
        OrderDTO result = orderService.createOrder(sampleDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Alice", result.getCustomerName());
        // Verify SRP: repository was called exactly once
        verify(orderRepository, times(1)).save(any(Order.class));
        // Verify SRP: validator was called exactly once
        verify(orderValidator, times(1)).validate(any(OrderDTO.class));
    }

    // TEST 2 — DIP: getAllOrders depends on repository interface, not concrete class
    @Test
    void shouldReturnAllOrders() {
        // Arrange
        when(orderRepository.findAll()).thenReturn(List.of(sampleOrder));

        // Act
        List<OrderDTO> result = orderService.getAllOrders();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getCustomerName());
    }

    // TEST 3 — Information Expert: calculateTotal is called on Order itself
    @Test
    void shouldCalculateCorrectTotal() {
        // Arrange: 2 items at $500 each = $1000
        when(orderRepository.findById(1L)).thenReturn(Optional.of(sampleOrder));

        // Act
        OrderDTO result = orderService.getOrderById(1L);

        // Assert
        assertEquals(1000.0, result.getTotal(),
                "Total should be 2 × $500 = $1000 — calculated by Order.calculateTotal()");
    }

    // TEST 4 — Protected Variations: exception thrown correctly for missing order
    @Test
    void shouldThrowOrderNotFoundWhenIdDoesNotExist() {
        // Arrange
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        // Act + Assert: OrderNotFoundException should be thrown
        assertThrows(OrderNotFoundException.class,
                () -> orderService.getOrderById(99L),
                "Should throw OrderNotFoundException for unknown ID");
    }

    // TEST 5 — Edge case: empty items list produces zero total
    @Test
    void shouldReturnZeroTotalWhenNoItems() {
        // Arrange: override items with empty list
        sampleOrder.setItems(new ArrayList<>());
        when(orderRepository.findById(1L)).thenReturn(Optional.of(sampleOrder));

        // Act
        OrderDTO result = orderService.getOrderById(1L);

        // Assert
        assertEquals(0.0, result.getTotal(), "Empty order should have $0.00 total");
    }

    // TEST 6 — Edge case: delete throws when order does not exist
    @Test
    void shouldThrowWhenDeletingNonExistentOrder() {
        // Arrange
        when(orderRepository.existsById(99L)).thenReturn(false);

        // Act + Assert
        assertThrows(OrderNotFoundException.class,
                () -> orderService.deleteOrder(99L));
    }

    // TEST 7 — SRP: deleteOrder delegates to repository and calls it exactly once
    @Test
    void shouldDeleteOrderSuccessfully() {
        // Arrange
        when(orderRepository.existsById(1L)).thenReturn(true);
        doNothing().when(orderRepository).deleteById(1L);

        // Act
        orderService.deleteOrder(1L);

        // Assert: deleteById was called exactly once — proves SRP delegation
        verify(orderRepository, times(1)).deleteById(1L);
    }

    // TEST 8 — OCP + Polymorphism: CashPayment processes without changing service
    @Test
    void shouldProcessCashPayment() {
        // Arrange
        when(orderRepository.findById(1L)).thenReturn(Optional.of(sampleOrder));
        Payment cash = new CashPayment();

        // Act
        String result = orderService.processPayment(1L, cash);

        // Assert
        assertTrue(result.contains("CASH"),
                "Result should mention CASH payment method");
    }

    // TEST 9 — OCP + Polymorphism: CardPayment processes without changing service
    @Test
    void shouldProcessCardPayment() {
        // Arrange
        when(orderRepository.findById(1L)).thenReturn(Optional.of(sampleOrder));
        Payment card = new CardPayment("1234");

        // Act
        String result = orderService.processPayment(1L, card);

        // Assert
        assertTrue(result.contains("CARD"),
                "Result should mention CARD payment method");
    }

    // TEST 10 — OCP: GCashPayment was added without changing service — works correctly
    @Test
    void shouldProcessGCashPayment() {
        // Arrange
        when(orderRepository.findById(1L)).thenReturn(Optional.of(sampleOrder));
        Payment gcash = new GCashPayment("09171234567");

        // Act
        String result = orderService.processPayment(1L, gcash);

        // Assert
        assertTrue(result.contains("GCASH"),
                "GCash payment added via OCP — zero changes to service required");
    }

    // TEST 11 — LSP: All Payment implementations are interchangeable
    @Test
    void allPaymentsShouldSubstitutePaymentInterface() {
        // SOLID: LSP - All three can be used wherever Payment is expected
        Payment[] payments = {
                new CashPayment(),
                new CardPayment("9999"),
                new GCashPayment("09991234567")
        };

        for (Payment payment : payments) {
            // LSP: process() must not throw for any valid implementation
            assertDoesNotThrow(() -> payment.process(100.0),
                    payment.getMethodName() + " should not throw on process()");
        }
    }

    // TEST 12 — Parameterized test: multiple invalid IDs all throw correctly
    // Bonus: Parameterized tests run the same test with different inputs automatically
    @ParameterizedTest
    @ValueSource(longs = {99L, 100L, 999L, -1L})
    void shouldThrowForAnyNonExistentId(Long nonExistentId) {
        // Arrange
        when(orderRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        // Act + Assert: every non-existent ID must throw
        assertThrows(OrderNotFoundException.class,
                () -> orderService.getOrderById(nonExistentId),
                "ID " + nonExistentId + " should throw OrderNotFoundException");
    }

    // TEST 13 — Edge case: null customer name in DTO (validator catches it)
    @Test
    void shouldCallValidatorBeforeCreatingOrder() {
        // Arrange: make validator throw (simulating invalid input)
        doThrow(new IllegalArgumentException("Customer name cannot be blank"))
                .when(orderValidator).validate(any(OrderDTO.class));

        // Act + Assert: the exception must propagate
        assertThrows(IllegalArgumentException.class,
                () -> orderService.createOrder(sampleDTO),
                "Validator should reject invalid input before any DB call");

        // Assert: repository save was NEVER called (SRP — validator stopped it)
        verify(orderRepository, never()).save(any(Order.class));
    }
}
