package grasp.deleon.app.util;

import grasp.deleon.app.dto.OrderDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// GRASP: Pure Fabrication tested in isolation - no mocks needed
class OrderValidatorTest {

    private OrderValidator validator;

    @BeforeEach
    void setUp() {
        validator = new OrderValidator();
    }

    // TEST 1 — Null DTO throws exception
    @Test
    void shouldThrowWhenDTOIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(null));
    }

    // TEST 2 — Blank customer name throws exception
    @Test
    void shouldThrowWhenCustomerNameIsBlank() {
        OrderDTO dto = new OrderDTO();
        dto.setCustomerName("   ");
        dto.setItems(List.of(new OrderDTO.OrderItemDTO("X", 1, 10.0)));

        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(dto));
    }

    // TEST 3 — Empty items list throws exception
    @Test
    void shouldThrowWhenItemsAreEmpty() {
        OrderDTO dto = new OrderDTO();
        dto.setCustomerName("Bob");
        dto.setItems(List.of());

        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(dto));
    }

    // TEST 4 — Zero quantity throws exception
    @Test
    void shouldThrowWhenQuantityIsZero() {
        OrderDTO dto = new OrderDTO();
        dto.setCustomerName("Bob");
        dto.setItems(List.of(new OrderDTO.OrderItemDTO("Item", 0, 10.0)));

        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(dto));
    }

    // TEST 5 — Valid DTO passes without exception
    @Test
    void shouldPassValidDTO() {
        OrderDTO dto = new OrderDTO();
        dto.setCustomerName("Bob");
        dto.setItems(List.of(new OrderDTO.OrderItemDTO("Item", 1, 10.0)));

        assertDoesNotThrow(() -> validator.validate(dto));
    }
}
