    package com.torrefranca.app.entity;

    import jakarta.persistence.*;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.Positive;
    import jakarta.validation.constraints.PositiveOrZero;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    @Entity
    @Table(name = "products")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Product Name is Required!")
        private String name;

        @NotBlank(message = "Invalid Description!")
        private String description;

        @NotBlank(message = "Product Price is Required!")
        @Positive(message = "Price Must Be Positive!")
        private Double price;

        @NotBlank(message = "Product Quantity is Required!")
        @PositiveOrZero(message = "Invalid Product Quantity!")
        private int quantity;

        @NotBlank(message = "Product Category is Required!")
        private String category;

    }
