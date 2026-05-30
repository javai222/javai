package com.example.demo.dto;

import com.example.demo.entity.Users;

public class UserMapper {


    public static UserDTO toDTO(Users user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .program(user.getProgram())
                .build();
    }


    public static Users toEntity(UserDTO dto) {
        return Users.builder()
                .id(dto.getId())
                .name(dto.getName())
                .program(dto.getProgram())
                .build();
    }
}