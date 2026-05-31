package com.tismo.productsapp.controller;

import com.tismo.productsapp.entity.Product;
import com.tismo.productsapp.entity.ProductItem;
import com.tismo.productsapp.service.ProductService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    ProductService service;

    @InjectMocks
    ProductController controller;

    @Test
    void shouldCreateProduct() {
        Product p = new Product();
        when(service.createProduct(p)).thenReturn(p);

        Product result = controller.create(p);

        assertEquals(p, result);
    }

    @Test
    void shouldGetAllProducts() {

        Product p1 = new Product();
        Product p2 = new Product();

        when(service.getAllProducts())
                .thenReturn(List.of(p1, p2));

        var result = controller.getAll();

        assertEquals(2, result.size());
        verify(service).getAllProducts();
    }

    @Test
    void shouldGetProductById() {

        Product product = new Product();
        product.setId(1L);

        when(service.getProductById(1L))
                .thenReturn(product);

        Product result =
                controller.getById(1L);

        assertEquals(1L, result.getId());

        verify(service).getProductById(1L);
    }

    @Test
    void shouldUpdateProduct() {

        Product updated = new Product();
        updated.setName("Laptop");

        when(service.updateProduct(1L, updated))
                .thenReturn(updated);

        Product result =
                controller.update(1L, updated);

        assertEquals(
                "Laptop",
                result.getName()
        );

        verify(service)
                .updateProduct(1L, updated);
    }

    @Test
    void shouldDeleteProduct() {

        controller.delete(1L);

        verify(service).deleteProduct(1L);
    }

    @Test
    void shouldAddItemToProduct() {

        Product product = new Product();

        ProductItem item =
                new ProductItem(
                        "Mouse",
                        2
                );

        when(service.addItemToProduct(
                1L,
                item))
                .thenReturn(product);

        Product result =
                controller.addItem(
                        1L,
                        item
                );

        assertEquals(
                product,
                result
        );

        verify(service)
                .addItemToProduct(
                        1L,
                        item
                );
    }
}
