package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.User;
import java.util.List;
import com.example.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userServiceImpl.createUser(user);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        return userServiceImpl.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userServiceImpl.deleteUser(id);
    }

    @GetMapping("/details")
    public List<User> getUser() {
        return userServiceImpl.getUser();
    }
}