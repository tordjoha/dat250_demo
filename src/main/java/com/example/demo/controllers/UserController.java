package com.example.demo.controllers;

import com.example.demo.dm.PollManager;
import com.example.demo.dm.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final PollManager pollManager;

    public UserController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return pollManager.addUser(user);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        User user = pollManager.getUser(username);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

}
