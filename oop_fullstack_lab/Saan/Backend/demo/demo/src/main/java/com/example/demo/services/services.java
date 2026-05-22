package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;
import java.util.List;



@Service
public class services {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    //Adding new people
    // Save many users at once
    public List<Users> saveAllUsers(List<Users> users) {

        if (users == null || users.isEmpty()) {
            throw new RuntimeException("The list of users cannot be empty");
        }
        return userRepository.saveAll(users);
    }


    public Users UserUpdate(Long Id, Users user) {
        Users existingUser = userRepository.findById(Id).orElseThrow(()->new RuntimeException("User not found with ID: " + Id));
        existingUser.setName(user.getName());
        existingUser.setProgram(user.getProgram());
        return userRepository.save(existingUser);
}

    //search by ID
    public Users getnamebyID(Long Id) {

        return userRepository.findById(Id).orElseThrow(() -> new RuntimeException("User not found with ID: " + Id));

    }

    //Delete users
    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
    }
}