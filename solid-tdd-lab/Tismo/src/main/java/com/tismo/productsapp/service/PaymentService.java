package com.tismo.productsapp.service;

import com.tismo.productsapp.dto.Receipt;
import com.tismo.productsapp.entity.Product;
import com.tismo.productsapp.util.PaymentStrategy;
import org.springframework.stereotype.Service;
import com.tismo.productsapp.constants.ErrorMessages;

@Service
public class PaymentService {

    // GRASP: Polymorphism - Different payment strategies can process payments differently
    // SOLID: SRP - PaymentService handles only payment-related operations
    // OOP Best Practice: Immutability - the service now implements the created immutable object
    public Receipt checkout(Product product,
                            PaymentStrategy payment) {

        if (product == null) {
            throw new IllegalArgumentException(
                    ErrorMessages.PRODUCT_NULL
            );
        }

        double total =
                payment.process(
                        product.calculateTotalValue()
                );

        return new Receipt(
                product.getName(),
                total
        );
    }
}

