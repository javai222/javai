package com.casapao.app.service;

import com.casapao.app.entity.User;
import com.casapao.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    // GET ALL USERS
    public List<User> getAll() {
        return repo.findAll();
    }

    // GET USER BY ID
    public User getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // CREATE USER
    public User create(User user) {
        return repo.save(user);
    }

    // UPDATE USER
    public User update(Long id, User updated) {
        return repo.findById(id)
                .map(user -> {
                    user.setName(updated.getName());
                    user.setEmail(updated.getEmail());
                    user.setPhoneNumber(updated.getPhoneNumber());
                    user.setRegular(updated.isRegular());
                    user.setRole(updated.getRole());
                    return repo.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // DELETE USER
    public void delete(Long id) {
        repo.deleteById(id);
    }
}