package com.conel.app;

import com.conel.app.entity.Product;
import com.conel.app.entity.User;
import com.conel.app.repository.ProductRepository;
import com.conel.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            userRepository.save(User.builder()
                    .name("Maria Santos").phoneNumber("+639171234567")
                    .email("maria@example.com").isRegular(true).role("ADMIN").build());
            userRepository.save(User.builder()
                    .name("Juan dela Cruz").phoneNumber("+639289876543")
                    .email("juan@example.com").isRegular(false).role("CUSTOMER").build());
            log.info("Seeded 2 users");
        }
        if (productRepository.count() == 0) {
            productRepository.save(Product.builder()
                    .name("Laptop Pro X").description("High-performance laptop")
                    .price(59999.00).stock(15).category("ELECTRONICS").build());
            productRepository.save(Product.builder()
                    .name("Wireless Mouse").description("Ergonomic Bluetooth mouse")
                    .price(1299.00).stock(80).category("ELECTRONICS").build());
            productRepository.save(Product.builder()
                    .name("Developer Hoodie").description("Comfortable hoodie")
                    .price(899.00).stock(50).category("CLOTHING").build());
            log.info("Seeded 3 products");
        }
    }
}