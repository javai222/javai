package com.tismo.productsapp.service;

import com.tismo.productsapp.dto.Receipt;
import com.tismo.productsapp.entity.Product;
import com.tismo.productsapp.util.implementation.CashPayment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

// SOLID: SRP - PaymentServiceTest handles only payment-related test operations
// OOP Best Practice: Immutability - the test now implements the created immutable object
@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @InjectMocks
    PaymentService paymentService;

    @Test
    void shouldCheckoutWithCash() {
        Product p = new Product();
        p.setName("Laptop");
        p.setPrice(100);
        p.addItem("item", 2);

        Receipt receipt = paymentService.checkout(
                p,
                new CashPayment()
        );

        assertEquals("Laptop", receipt.getProductName());
        assertEquals(200, receipt.getTotal());
    }

    @Test
    void shouldHandleEmptyItems() {
        Product p = new Product();
        p.setName("Laptop");
        p.setPrice(100);

        Receipt receipt = paymentService.checkout(
                p,
                new CashPayment()
        );

        assertEquals(0, receipt.getTotal());
    }

    @Test
    void shouldThrowWhenProductIsNull() {

        assertThrows(
                IllegalArgumentException.class,
                () -> paymentService.checkout(
                        null,
                        new CashPayment()
                )
        );
    }
}
