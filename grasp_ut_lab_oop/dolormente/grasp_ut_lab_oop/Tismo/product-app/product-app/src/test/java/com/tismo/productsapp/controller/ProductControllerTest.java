package com.tismo.productsapp.controller;

import com.tismo.productsapp.entity.Product;
import com.tismo.productsapp.service.ProductService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {

    ProductService service = mock(ProductService.class);
    ProductController controller = new ProductController(service);

    @Test
    void shouldCreateProduct() {
        Product p = new Product();
        when(service.createProduct(p)).thenReturn(p);

        Product result = controller.create(p);

        assertEquals(p, result);
    }
}
