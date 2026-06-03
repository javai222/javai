package grasp.deleon.app.service;

import grasp.deleon.app.dto.OrderDTO;
import grasp.deleon.app.entity.*;
import grasp.deleon.app.repository.OrderRepository;
import grasp.deleon.app.util.OrderNotFoundException;
import grasp.deleon.app.util.OrderValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

// GRASP: Controller principle validated here - service is tested in isolation
// Uses Mockito to mock the repository so no real database is ever called
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    // GRASP: Low Coupling demonstrated - we mock the interface, not a concrete class
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderValidator orderValidator;

    // Injects the mocks above into the real OrderService
    @InjectMocks
    private OrderService orderService;

    private Order sampleOrder;
    private OrderDTO sampleDTO;

    @BeforeEach
    void setUp() {
        // Build a sample Order entity to reuse across tests
        sampleOrder = new Order();
        sampleOrder.setId(1L);
        sampleOrder.setCustomerName("Alice");
        sampleOrder.setStatus(OrderStatus.PENDING);
        sampleOrder.setCreatedAt(LocalDateTime.now());

        OrderItem item = new OrderItem("Laptop", 2, 500.0);
        sampleOrder.setItems(new ArrayList<>(List.of(item)));

        // Build a matching DTO
        sampleDTO = new OrderDTO();
        sampleDTO.setCustomerName("Alice");

        OrderDTO.OrderItemDTO itemDTO = new OrderDTO.OrderItemDTO("Laptop", 2, 500.0);
        sampleDTO.setItems(List.of(itemDTO));
    }

    // TEST 1 — Creating an order returns a DTO with correct customer name
    @Test
    void shouldCreateOrder() {
        // Arrange: tell the mock repository what to return when save() is called
        when(orderRepository.save(any(Order.class))).thenReturn(sampleOrder);
        doNothing().when(orderValidator).validate(any(OrderDTO.class));

        // Act: call the real service method
        OrderDTO result = orderService.createOrder(sampleDTO);

        // Assert: verify the result is correct
        assertNotNull(result);
        assertEquals("Alice", result.getCustomerName());
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    // TEST 2 — Getting all orders returns a list
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

    // TEST 3 — Getting an order by ID that exists returns the correct DTO
    @Test
    void shouldGetOrderById() {
        // Arrange
        when(orderRepository.findById(1L)).thenReturn(Optional.of(sampleOrder));

        // Act
        OrderDTO result = orderService.getOrderById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    // TEST 4 — Getting an order that does NOT exist throws OrderNotFoundException
    @Test
    void shouldThrowExceptionWhenOrderNotFound() {
        // Arrange: mock returns empty optional (order not found)
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        // Act + Assert: expect the custom exception
        assertThrows(OrderNotFoundException.class,
                () -> orderService.getOrderById(99L));
    }

    // TEST 5 — Deleting an order that does not exist throws OrderNotFoundException
    @Test
    void shouldThrowWhenDeletingNonExistentOrder() {
        // Arrange
        when(orderRepository.existsById(99L)).thenReturn(false);

        // Act + Assert
        assertThrows(OrderNotFoundException.class,
                () -> orderService.deleteOrder(99L));
    }

    // TEST 6 — Deleting an existing order calls repository deleteById once
    @Test
    void shouldDeleteExistingOrder() {
        // Arrange
        when(orderRepository.existsById(1L)).thenReturn(true);
        doNothing().when(orderRepository).deleteById(1L);

        // Act
        orderService.deleteOrder(1L);

        // Assert: verify deleteById was called exactly once
        verify(orderRepository, times(1)).deleteById(1L);
    }

    // TEST 7 — Total calculation works correctly (Information Expert tested)
    @Test
    void shouldCalculateOrderTotal() {
        // Arrange: order has 2 x $500 = $1000
        when(orderRepository.findById(1L)).thenReturn(Optional.of(sampleOrder));

        // Act
        OrderDTO result = orderService.getOrderById(1L);

        // Assert: total should be 1000.0
        assertEquals(1000.0, result.getTotal());
    }

    // TEST 8 — Edge case: empty items list produces zero total
    @Test
    void shouldReturnZeroTotalForEmptyItems() {
        // Arrange: order with no items
        sampleOrder.setItems(new ArrayList<>());
        when(orderRepository.findById(1L)).thenReturn(Optional.of(sampleOrder));

        // Act
        OrderDTO result = orderService.getOrderById(1L);

        // Assert
        assertEquals(0.0, result.getTotal());
    }

    // TEST 9 — Polymorphism: CashPayment processes correctly
    @Test
    void shouldProcessCashPayment() {
        // Arrange
        when(orderRepository.findById(1L)).thenReturn(Optional.of(sampleOrder));
        Payment cashPayment = new CashPayment();

        // Act
        String result = orderService.processPayment(1L, cashPayment);

        // Assert
        assertTrue(result.contains("CASH"));
    }

    // TEST 10 — Polymorphism: CardPayment processes correctly
    @Test
    void shouldProcessCardPayment() {
        // Arrange
        when(orderRepository.findById(1L)).thenReturn(Optional.of(sampleOrder));
        Payment cardPayment = new CardPayment("1234");

        // Act
        String result = orderService.processPayment(1L, cardPayment);

        // Assert
        assertTrue(result.contains("CARD"));
    }
}
