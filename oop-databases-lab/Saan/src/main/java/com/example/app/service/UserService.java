package com.example.app.service;

import com.example.app.model.User;
import com.example.app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAll()              { return userRepository.findAll(); }
    public Optional<User> getById(Long id)  { return userRepository.findById(id); }
    public User save(User user)             { return userRepository.save(user); }

    public User update(Long id, User updated) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setPhoneNumber(updated.getPhoneNumber());
        existing.setRegular(updated.isRegular());
        existing.setRole(updated.getRole());
        return userRepository.save(existing);
    }

    public void delete(Long id) { userRepository.deleteById(id); }
}