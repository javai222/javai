package com.dolormente.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Robots")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Robot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;


    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email")
    private String email;

    private Boolean isRegular;

    private Boolean isAdvancedRobot;

    @NotBlank(message = "Rank is required")
    private String rank;
}
