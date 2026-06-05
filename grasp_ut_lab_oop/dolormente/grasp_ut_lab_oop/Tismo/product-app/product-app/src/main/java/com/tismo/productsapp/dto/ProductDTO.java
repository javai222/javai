package com.tismo.productsapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// GRASP: Protected Variations - DTO isolates API layer from entity changes
public class ProductDTO {

    private String name;
    private double price;
}
