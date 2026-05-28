package com.plantilla.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Order number is required") // Validation
    private String orderNumber;

    @NotBlank(message = "Customer name is required") // Validation
    private String customerName;

    @NotNull(message = "Total amount is required") // Validation
    private Double totalAmount;

    @NotBlank(message = "Status is required") // Validation
    private String status;

    @NotBlank(message = "Payment method is required") // Validation
    private String paymentMethod;

}