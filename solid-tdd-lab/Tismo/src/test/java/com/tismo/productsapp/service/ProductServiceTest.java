package com.tismo.productsapp.service;

import com.tismo.productsapp.entity.Product;
import com.tismo.productsapp.entity.ProductItem;
import com.tismo.productsapp.exception.ProductNotFoundException;
import com.tismo.productsapp.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    // SOLID: DIP - ProductService depends on repository abstraction injected by Spring
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
    void shouldGetProductById() {

        Product product = new Product();
        product.setId(1L);

        when(repo.findById(1L))
                .thenReturn(Optional.of(product));

        Product result =
                service.getProductById(1L);

        assertEquals(1L, result.getId());
    }

    @Test
    void shouldReturnAllProducts() {
        when(repo.findAll()).thenReturn(List.of(new Product()));

        List<Product> list = service.getAllProducts();

        assertEquals(1, list.size());
    }

    @Test
    void shouldThrowWhenProductNotFound() {

        when(repo.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(
                ProductNotFoundException.class,
                () -> service.getProductById(1L)
        );
    }

    @Test
    void shouldUpdateProduct() {

        Product existing = new Product();
        existing.setId(1L);
        existing.setName("Old");

        Product updated = new Product();
        updated.setName("New");
        updated.setPrice(200);

        when(repo.findById(1L))
                .thenReturn(Optional.of(existing));

        when(repo.save(existing))
                .thenReturn(existing);

        Product result =
                service.updateProduct(1L, updated);

        assertEquals("New", result.getName());
        assertEquals(200, result.getPrice());
    }

    @Test
    void shouldDeleteProduct() {

        Product product = new Product();
        product.setId(1L);

        when(repo.findById(1L))
                .thenReturn(Optional.of(product));

        service.deleteProduct(1L);

        verify(repo).delete(product);
    }

    @Test
    void shouldAddItemToProduct() {

        Product product = new Product();
        product.setId(1L);

        ProductItem item =
                new ProductItem("Mouse", 2);

        when(repo.findById(1L))
                .thenReturn(Optional.of(product));

        when(repo.save(product))
                .thenReturn(product);

        Product result =
                service.addItemToProduct(
                        1L,
                        item
                );

        assertEquals(
                1,
                result.getItems().size()
        );
    }

}