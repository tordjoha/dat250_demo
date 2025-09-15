package com.example.demo.dm;

import java.util.UUID;

public class User {
    private String username;
    private String email;
    private final String id;

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public User(String username, String email , String id) {
        this.username = username;
        this.email = email;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

}
