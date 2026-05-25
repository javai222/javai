package com.silva.productsact.product_app.Controller;

import com.silva.productsact.product_app.Entity.Products;
import com.silva.productsact.product_app.Service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// GRASP Controller is used here. It acts as the first layer to receive and coordinate the system.
@RestController // GRASP: Controller boundary role
@RequestMapping("/api/products")
public class ProductsController {
// GRASP Low Coupling was handled here as it depends on the Abstraction and not to Implementation.
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Products> createProduct(
            @RequestParam String name,
            @RequestParam double productPrice) {
        // This condition is highly cohesive because it doesn't allow any hardcore or useless processes to enter
        if (name == null || name.trim().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (productPrice < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Products savedProduct = productService.createAndProcessProduct(name, productPrice);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}