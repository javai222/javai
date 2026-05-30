package com.mance.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Players")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone No. is required")
    private String phoneNumber;

    @Email(message = "Please input a valid email")
    @NotBlank(message = "Email is required")
    private String email;

    private Boolean isAcePlayer;

    @NotBlank(message = "Rank is required")
    private String rank;

}
