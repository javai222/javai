package com.torrefranca.product_management.service;

import com.torrefranca.product_management.dto.ProductDto;
import com.torrefranca.product_management.entity.Product;
import com.torrefranca.product_management.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository repository;

    @InjectMocks
    ProductService service;

    @Test
    void shouldCreateProduct() {

        ProductDto dto = new ProductDto(
                "Laptop",
                "Electronics",
                50000,
                5
        );

        Product saved = new Product(
                1L,
                "Laptop",
                "Electronics",
                50000,
                5
        );

        when(repository.save(any(Product.class)))
                .thenReturn(saved);

        Product result = service.createProduct(dto);

        assertEquals("Laptop", result.getName());
    }

    @Test
    void shouldGetAllProducts() {

        when(repository.findAll())
                .thenReturn(List.of(
                        new Product(),
                        new Product()
                ));

        assertEquals(
                2,
                service.getAllProducts().size()
        );
    }

    @Test
    void shouldDeleteProduct() {

        service.deleteProduct(1L);

        verify(repository)
                .deleteById(1L);
    }

    @Test
    void shouldHandleEmptyProductList() {

        when(repository.findAll())
                .thenReturn(List.of());

        assertTrue(
                service.getAllProducts().isEmpty()
        );
    }

    @Test
    void shouldCreateProductWithValidPrice() {

        ProductDto dto = new ProductDto(
                "Mouse",
                "Electronics",
                1000,
                2
        );

        when(repository.save(any(Product.class)))
                .thenAnswer(i -> i.getArgument(0));

        Product result = service.createProduct(dto);

        assertEquals(
                1000,
                result.getPrice()
        );
    }
}