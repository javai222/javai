package com.tismo.productsapp.service;

import com.tismo.productsapp.entity.Product;
import com.tismo.productsapp.util.implementation.CashPayment;
import com.tismo.productsapp.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository repo;

    @InjectMocks
    ProductService service;

    @Test
    void shouldCreateProduct() {
        Product p = new Product();
        when(repo.save(p)).thenReturn(p);

        Product result = service.createProduct(p);

        assertEquals(p, result);
        verify(repo).save(p);
    }

    @Test
    void shouldReturnAllProducts() {
        when(repo.findAll()).thenReturn(List.of(new Product()));

        List<Product> list = service.getAllProducts();

        assertEquals(1, list.size());
    }

    @Test
    void shouldCheckoutWithCash() {
        Product p = new Product();
        p.setPrice(100);
        p.addItem("item", 2);

        double result = service.checkout(p, new CashPayment());

        assertEquals(200, result);
    }

    @Test
    void shouldHandleEmptyItems() {
        Product p = new Product();
        p.setPrice(100);

        double result = service.checkout(p, new CashPayment());

        assertEquals(0, result);
    }

    @Test
    void shouldThrowWhenNullProduct() {
        assertThrows(NullPointerException.class, () -> {
            service.checkout(null, new CashPayment());
        });
    }
}