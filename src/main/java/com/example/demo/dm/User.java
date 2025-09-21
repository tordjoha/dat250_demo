package com.example.demo.dm;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;
import java.util.UUID;

public class User {
    private String username;
    private String email;
    private LinkedHashSet<Poll> created;

    public User() {
        this.created = new LinkedHashSet<>();
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.created = new LinkedHashSet<>();
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

    /**
     * Creates a new Poll object for this user
     * with the given poll question
     * and returns it.
     */
    public Poll createPoll(String question) {
        String id = UUID.randomUUID().toString();
        Instant publishedAt = Instant.now();
        Instant validUntil = publishedAt.plus(24, ChronoUnit.HOURS);
        Poll poll = new Poll(id, question, publishedAt, validUntil);
        created.add(poll);
        return poll;

    }

    /**
     * Creates a new Vote for a given VoteOption in a Poll
     * and returns the Vote as an object.
     */
    public Vote voteFor(VoteOption option) {
        // TODO: implement
        return null;
    }
}
