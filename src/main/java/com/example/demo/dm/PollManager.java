package com.example.demo.dm;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Poll> polls = new HashMap<>();

    public User getUser(String username) {
        users.get(username);
    }

    public User addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public Poll getPoll(String question) {
        polls.get(question);
    }

    public Poll addPoll(Poll poll) {
        polls.put(poll.getQuestion(), poll);
    }
}
