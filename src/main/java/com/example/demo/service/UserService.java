package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository users;

    public String addUser(User user) {
        if (!isValidEmail(user.getEmail())) {
            return "Invalid email format: " + user.getEmail();
        }
        users.save(user);
        return "User added successfully: " + user.getName();
    }

    public List<User> getUsers() {
        return users.findAll();
    }

    public Optional<User> getUserByRollNo(Long rollNo) {
        return users.findById(rollNo);
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".") && email.indexOf("@") < email.lastIndexOf(".");
    }

    public String updateUser(Long rollNo, User updatedUser) {
        Optional<User> existingUser = users.findById(rollNo);
        if (existingUser.isPresent()) {
            User newUser = new User(rollNo, updatedUser.getName(), updatedUser.getEmail());

            users.save(newUser);
            return "User updated successfully: " + newUser.getName();
        } else {
            return "User not found with Roll No: " + rollNo;
        }
    }

    public String deleteUser(Long rollNo) {
        if (users.existsById(rollNo)) {
            users.deleteById(rollNo);
            return "User deleted successfully with Roll No: " + rollNo;
        } else {
            return "User not found with Roll No: " + rollNo;
        }
    }
}