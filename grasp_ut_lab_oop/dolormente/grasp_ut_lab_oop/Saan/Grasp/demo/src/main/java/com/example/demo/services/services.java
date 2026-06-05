package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserMapper;
import com.example.demo.entity.Users;
import com.example.demo.exception.InvalidUserException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// GRASP: Information Expert, Low Coupling, High Cohesion, Creator
@Service
public class services implements UserServiceInterface {

    private final UserRepository userRepository;

    public services(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    @Override
    public List<UserDTO> saveAllUsers(List<UserDTO> users) {
        validateUserList(users);
        List<Users> entities = users.stream()
                .map(UserMapper::toEntity)
                .toList();
        return userRepository.saveAll(entities)
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO user) {
        Users existingUser = findUserOrThrow(id);
        Users updatedUser = Users.builder()
                .id(existingUser.getId())
                .name(user.getName())
                .program(user.getProgram())
                .build();
        return UserMapper.toDTO(userRepository.save(updatedUser));
    }

    @Override
    public UserDTO getUserById(Long id) {
        return UserMapper.toDTO(findUserOrThrow(id));
    }

    @Override
    public void deleteUserById(Long id) {
        findUserOrThrow(id);
        userRepository.deleteById(id);
    }

    // GRASP: Pure Fabrication — reusable helper
    private Users findUserOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // GRASP: Pure Fabrication — reusable validation
    private void validateUserList(List<UserDTO> users) {
        if (users == null || users.isEmpty()) {
            throw new InvalidUserException("The list of users cannot be empty");
        }
    }
}