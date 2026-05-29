package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import java.util.List;

public interface UserServiceInterface {
    List<UserDTO> getAllUsers();
    List<UserDTO> saveAllUsers(List<UserDTO> users);
    UserDTO updateUser(Long id, UserDTO user);
    UserDTO getUserById(Long id);
    void deleteUserById(Long id);
}