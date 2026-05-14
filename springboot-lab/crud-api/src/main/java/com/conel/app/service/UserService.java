package com.conel.app.service;

import com.conel.app.dto.UserDTO;
import com.conel.app.entity.User;
import com.conel.app.exception.ResourceNotFoundException;
import com.conel.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", id));
        return mapToDTO(user);
    }

    public UserDTO createUser(UserDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already in use: " + dto.getEmail());
        }
        return mapToDTO(userRepository.save(mapToEntity(dto)));
    }

    public UserDTO updateUser(Long id, UserDTO dto) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", id));
        if (dto.getName() != null)        existing.setName(dto.getName());
        if (dto.getPhoneNumber() != null) existing.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getEmail() != null)       existing.setEmail(dto.getEmail());
        if (dto.getRole() != null)        existing.setRole(dto.getRole());
        existing.setRegular(dto.isRegular());
        return mapToDTO(userRepository.save(existing));
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User", id);
        }
        userRepository.deleteById(id);
    }

    private UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId()).name(user.getName())
                .phoneNumber(user.getPhoneNumber()).email(user.getEmail())
                .isRegular(user.isRegular()).role(user.getRole()).build();
    }

    private User mapToEntity(UserDTO dto) {
        return User.builder()
                .name(dto.getName()).phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail()).isRegular(dto.isRegular())
                .role(dto.getRole()).build();
    }
}