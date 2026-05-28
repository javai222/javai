package com.plantilla.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Item name is required") // Validation
    private String itemName;

    @NotBlank(message = "Item code is required") // Validation
    private String itemCode;

    @NotNull(message = "Quantity is required") // Validation
    private Integer quantity;

    @NotNull(message = "Price is required") // Validation
    private Double price;

    @NotNull(message = "Availability is required") // Validation
    private Boolean isAvailable;

}