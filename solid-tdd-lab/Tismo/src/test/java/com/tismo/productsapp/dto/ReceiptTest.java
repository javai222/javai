package com.tismo.productsapp.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {

    @Test
    void shouldCreateImmutableReceipt() {

        Receipt receipt =
                new Receipt("Laptop", 50000);

        assertEquals("Laptop",
                receipt.getProductName());

        assertEquals(50000,
                receipt.getTotal());
    }
}