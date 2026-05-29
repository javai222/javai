package com.nu.bscs.a.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String section;
    private String course;

}
