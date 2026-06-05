package com.silva.productsact.product_app.Service;

import com.silva.productsact.product_app.Entity.Products;
import com.silva.productsact.product_app.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ProductsServiceTest {

    @Test
    public void testCreateAndProcessProduct() {
        // Arrange
        ProductRepository repositoryMock = Mockito.mock(ProductRepository.class);
        ProductService productService = new ProductService(repositoryMock);

        Products fakeProduct = new Products("Laptop", 999.99);
        when(repositoryMock.save(any(Products.class))).thenReturn(fakeProduct);

        // Act
        Products result = productService.createAndProcessProduct("Laptop", 999.99);

        // Assert
        assertNotNull(result);
    }
}