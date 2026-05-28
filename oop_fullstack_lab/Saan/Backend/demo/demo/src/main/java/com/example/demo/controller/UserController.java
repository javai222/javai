package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.services;
import com.example.demo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"}, allowCredentials = "true")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private services userService;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity<List<Users>> createUsers(@RequestBody List<Users> users) {
        // This calls the saveAllUsers method you just added to your service
        List<Users> savedUsers = userService.saveAllUsers(users);
        return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
    }

    @PutMapping("/{updateId}")
    public ResponseEntity<Users> updateUsers(@PathVariable Long updateId, @RequestBody Users user) {
        Users updatedUser = userService.UserUpdate(updateId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsers(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}

