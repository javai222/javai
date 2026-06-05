package com.silva.productsact.product_app.Controller;

import com.silva.productsact.product_app.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductsControllerTest {

    @Test
    void shouldReturnBadRequestWhenNameIsEmpty() {

        ProductService mockService = Mockito.mock(ProductService.class);

        ProductsController controller =
                new ProductsController(mockService);

        ResponseEntity<?> response =
                controller.createProduct("", 100.00);

        assertEquals(HttpStatus.BAD_REQUEST,
                response.getStatusCode());
    }

    @Test
    void shouldReturnBadRequestWhenPriceIsNegative() {

        ProductService mockService = Mockito.mock(ProductService.class);

        ProductsController controller =
                new ProductsController(mockService);

        ResponseEntity<?> response =
                controller.createProduct("Laptop", -100.00);

        assertEquals(HttpStatus.BAD_REQUEST,
                response.getStatusCode());
    }
}
