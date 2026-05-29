package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.services.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// GRASP: Controller, Low Coupling, Indirection
@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"}, allowCredentials = "true")
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceInterface userService;

    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<List<UserDTO>> createUsers(@RequestBody List<UserDTO> users) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveAllUsers(users));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUsers(@PathVariable Long id, @RequestBody UserDTO user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsers(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}