package com.torrefranca.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Item Name is Required!")
    private String name;

    @NotBlank(message = "Phone Number is Required!")
    private String phoneNumber;

    @NotBlank(message = "Email is Required!")
    private String email;

    private Boolean isRegular;

    @NotBlank(message = "Role is Required!")
    private String role;

}
