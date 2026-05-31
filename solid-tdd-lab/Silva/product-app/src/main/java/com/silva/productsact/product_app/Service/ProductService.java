package com.silva.productsact.product_app.Service;

/* The connection to ProductService --> ProductRepository --> Database is an example of Indirection as it serves as
a structural buffer and keeping the logics clean from coding errors*/

import com.silva.productsact.product_app.Entity.Products;
import com.silva.productsact.product_app.Repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Products createAndProcessProduct(String name, double productPrice) {
        /* GRASP Creator used here. ProductService assigned the responsibility of Creator instead of the Controller.
        It also includes High Cohesion.*/
        Products product = new Products(name, productPrice);
        return productRepository.save(product);
    }
}
