package com.javier.app.service;

import com.javier.app.entity.User;
import com.javier.app.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() { return userRepository.findAll(); }

    public User getById(Long id) { return userRepository.findById(id).orElseThrow(); }

    public User create(User user) { return userRepository.save(user); }

    public User update(Long id, User updated) {
        User user = getById(id);
        user.setName(updated.getName());
        user.setEmail(updated.getEmail());
        user.setPhoneNumber(updated.getPhoneNumber());
        user.setRegular(updated.isRegular());
        user.setRole(updated.getRole());
        return userRepository.save(user);
    }

    public void delete(Long id) { userRepository.deleteById(id); }
}