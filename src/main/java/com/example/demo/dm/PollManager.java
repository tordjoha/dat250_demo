package com.example.demo.dm;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class PollManager {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Poll> polls = new HashMap<>();

    public User getUser(String username) {
        return users.get(username);
    }

    public User addUser(User user) {
       users.put(user.getUsername(), user);
       return user;
    }

    public Poll getPoll(String id) {
        return polls.get(id);
    }

    public Poll addPoll(Poll poll) {
        if (poll.getId() == null || poll.getId().isEmpty()) {
         poll.setId(UUID.randomUUID().toString());
        }
        polls.put(poll.getId(), poll);
        return poll;
    }

    public Poll removePoll(String id) {
        return polls.remove(id);
    }

    public Map<String, Poll> getAllPolls() {
        return polls;
    }
}
