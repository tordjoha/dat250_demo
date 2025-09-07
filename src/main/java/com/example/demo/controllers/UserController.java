package com.example.demo.controllers;

import com.example.demo.dm.PollManager;
import com.example.demo.dm.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final PollManager pollManager;

    @Autowired
    public UserController(PollManager pollManager)
    {
        this.pollManager = pollManager;
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        pollManager.addUser(user);
    }
}
