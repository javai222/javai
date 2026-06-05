package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Users;
import com.example.demo.exception.InvalidUserException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class servicesTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    services userService;

    @Test
    void getAllUsers_returnsList() {
        // Arrange
        Users user = Users.builder()
                .id(1L)
                .name("Maria")
                .program("BSIT")
                .build();
        when(userRepository.findAll()).thenReturn(List.of(user));

        // Act
        List<UserDTO> result = userService.getAllUsers();

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Maria");
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void saveAllUsers_savesAndReturnsDTOs() {
        // Arrange
        UserDTO dto = UserDTO.builder()
                .name("John")
                .program("BSCS")
                .build();
        Users entity = Users.builder()
                .id(1L)
                .name("John")
                .program("BSCS")
                .build();
        when(userRepository.saveAll(anyList())).thenReturn(List.of(entity));

        // Act
        List<UserDTO> result = userService.saveAllUsers(List.of(dto));

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("John");
        verify(userRepository, times(1)).saveAll(anyList());
    }

    @Test
    void saveAllUsers_throwsOnEmptyList() {
        // Arrange
        List<UserDTO> emptyList = Collections.emptyList();

        // Act & Assert
        assertThrows(InvalidUserException.class, () -> {
            userService.saveAllUsers(emptyList);
        });

        verify(userRepository, never()).saveAll(anyList());
    }

    @Test
    void updateUser_updatesAndReturnsDTO() {
        // Arrange
        Long id = 1L;
        UserDTO dto = UserDTO.builder()
                .name("Updated")
                .program("BSIT")
                .build();
        Users existing = Users.builder()
                .id(id)
                .name("Old")
                .program("BSIT")
                .build();
        Users saved = Users.builder()
                .id(id)
                .name("Updated")
                .program("BSIT")
                .build();
        when(userRepository.findById(id)).thenReturn(Optional.of(existing));
        when(userRepository.save(any(Users.class))).thenReturn(saved);

        // Act
        UserDTO result = userService.updateUser(id, dto);

        // Assert
        assertThat(result.getName()).isEqualTo("Updated");
        verify(userRepository, times(1)).findById(id);
        verify(userRepository, times(1)).save(any(Users.class));
    }

    @Test
    void deleteUser_throwsWhenNotFound() {
        // Arrange
        Long id = 1L;
        when(userRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> {
            userService.deleteUserById(id);
        });

        verify(userRepository, times(1)).findById(id);
        verify(userRepository, never()).deleteById(id);
    }

    @Test
    void getUserById_throwsWhenNotFound() {
        // Arrange
        Long id = 1L;
        when(userRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> {
            userService.getUserById(id);
        });

        verify(userRepository, times(1)).findById(id);
    }

    @Test
    void getUserById_returnsDTO() {
        // Arrange
        Long id = 1L;
        Users user = Users.builder()
                .id(id)
                .name("Maria")
                .program("BSIT")
                .build();
        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        // Act
        UserDTO result = userService.getUserById(id);

        // Assert
        assertThat(result.getName()).isEqualTo("Maria");
        verify(userRepository, times(1)).findById(id);
    }
}