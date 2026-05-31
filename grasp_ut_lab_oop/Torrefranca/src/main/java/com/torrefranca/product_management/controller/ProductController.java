package com.torrefranca.product_management.controller;

import com.torrefranca.product_management.dto.ProductDto;
import com.torrefranca.product_management.entity.Product;
import com.torrefranca.product_management.service.ProductService;
import com.torrefranca.product_management.util.HolidayDiscount;
import com.torrefranca.product_management.util.StudentDiscount;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// GRASP: Controller
// Handles HTTP requests and delegates work to ProductService

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductDto dto) {
        return productService.createProduct(dto);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDto dto) {

        return productService.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}/student-discount")
    public double getStudentDiscount(@PathVariable Long id) {
        return productService.calculateDiscountedPrice(
                id,
                new StudentDiscount()
        );
    }

    @GetMapping("/{id}/holiday-discount")
    public double getHolidayDiscount(@PathVariable Long id) {
        return productService.calculateDiscountedPrice(
                id,
                new HolidayDiscount()
        );
    }
}