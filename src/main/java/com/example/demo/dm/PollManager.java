package com.example.demo.dm;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Poll> polls = new HashMap<>();

    public void getUser(String username) {
        users.get(username);
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public void getPoll(String question) {
        polls.get(question);
    }

    public void addPoll(Poll poll) {
        polls.put(poll.getQuestion(), poll);
    }
}
