package com.torrefranca.product_management.controller;

import com.torrefranca.product_management.entity.Product;
import com.torrefranca.product_management.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    ProductService service;

    @InjectMocks
    ProductController controller;

    @Test
    void shouldReturnAllProducts() {

        when(service.getAllProducts())
                .thenReturn(List.of(
                        new Product(),
                        new Product()
                ));

        assertEquals(
                2,
                controller.getAllProducts().size()
        );
    }
}