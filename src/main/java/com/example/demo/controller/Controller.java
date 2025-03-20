package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public String UserCreation(@RequestBody User user1) {
        return userService.addUser(user1);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getUsers();
    }

    @GetMapping("/get/{rollNo}")
    public Optional<User> getUserByRollNo(@PathVariable Long rollNo) {
        return userService.getUserByRollNo(rollNo);
    }

    @PatchMapping("/update/{rollNo}")
    public String updateUser(@PathVariable Long rollNo, @RequestBody User user) {
        return userService.updateUser(rollNo, user);
    }

    @DeleteMapping("/delete/{rollNo}")
    public String deleteUser(@PathVariable Long rollNo) {
        return userService.deleteUser(rollNo);
    }
}