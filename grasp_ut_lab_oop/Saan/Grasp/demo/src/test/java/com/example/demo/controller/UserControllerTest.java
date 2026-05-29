package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.services.UserServiceInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    UserServiceInterface userService;

    UserDTO fakeUser;

    @BeforeEach
    void setUp() {
        // Arrange - shared fake data
        fakeUser = UserDTO.builder()
                .id(1L)
                .name("Kira")
                .program("BSIT")
                .build();
    }

    @Test
    void getAllUsers_returnsOk() throws Exception {
        // Arrange
        List<UserDTO> users = List.of(fakeUser);
        when(userService.getAllUsers()).thenReturn(users);

        // Act & Assert
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Kira"));
    }

    @Test
    void createUsers_returnsCreated() throws Exception {
        // Arrange
        List<UserDTO> users = List.of(fakeUser);
        when(userService.saveAllUsers(anyList())).thenReturn(users);

        // Act & Assert
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[{\"name\":\"Kira\",\"program\":\"BSIT\"}]"))
                .andExpect(status().isCreated());
    }

    @Test
    void updateUser_returnsOk() throws Exception {
        // Arrange
        when(userService.updateUser(eq(1L), any(UserDTO.class))).thenReturn(fakeUser);

        // Act & Assert
        mockMvc.perform(put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Kira\",\"program\":\"BSIT\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteUser_returnsOk() throws Exception {
        // Arrange
        doNothing().when(userService).deleteUserById(1L);

        // Act & Assert
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isOk());
    }
}