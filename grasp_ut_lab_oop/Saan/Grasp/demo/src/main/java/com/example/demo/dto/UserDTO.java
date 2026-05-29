package com.example.demo.dto;

import lombok.*;

// DTO Pattern — separates API layer data from entity/domain layer
// GRASP: Information Expert — carries only data needed for API communication
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String program;
}