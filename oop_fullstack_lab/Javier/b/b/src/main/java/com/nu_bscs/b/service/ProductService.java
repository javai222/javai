package com.nu_bscs.b.service;

import com.nu_bscs.b.model.Product;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByPriceRange(BigDecimal min, BigDecimal max);
    List<Product> searchProducts(String keyword);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product updatedProduct);
    void deleteProduct(Long id);

}