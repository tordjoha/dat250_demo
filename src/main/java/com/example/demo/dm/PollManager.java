package com.example.demo.dm;

import com.example.demo.service.RedisPollCache;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class PollManager {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Poll> polls = new HashMap<>();
    private final RedisPollCache redisPollCache;
    private static final long POLL_CACHE_TTL = 600; // 10 minutes

    public PollManager(RedisPollCache redisPollCache) {
        this.redisPollCache = redisPollCache;
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public User addUser(User user) {
        if (users.containsKey(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        users.put(user.getUsername(), user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public Poll getPoll(String id) {
        return polls.get(id);
    }

    public Poll addPoll(Poll poll) {
        if (poll.getId() == null || poll.getIdentifier().isEmpty()) {
         poll.setIdentifier(UUID.randomUUID().toString());
        }
        polls.put(poll.getIdentifier(), poll);
        redisPollCache.cachePollResults(Long.valueOf(poll.getIdentifier()), Map.of(), POLL_CACHE_TTL);
        return poll;
    }

    public Poll removePoll(String id) {
        return polls.remove(id);
    }

    public Map<String, Poll> getAllPolls() {
        return polls;
    }

    public Vote addVote(String pollId, Vote vote) {
        Poll poll = polls.get(pollId);
        if (poll == null) {
            throw new IllegalArgumentException("Poll with id " + pollId + " does not exist");
        }
        poll.getVotes().add(vote);
        redisPollCache.invalidatePoll(Long.valueOf(pollId));
        return vote;
    }

    public Map<String, String> getVotes(String pollId) {
        Long pollIdLong;
        try {
            pollIdLong = Long.valueOf(pollId);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid poll ID: " + pollId);
        }

        Map<String, String> cachedResults = redisPollCache.getPollResults(pollIdLong);
        if (!cachedResults.isEmpty()) {
            return cachedResults;
        }

        Poll poll = polls.get(pollId);
        if (poll == null) {
            return Map.of();
        }

        Map<String, String> aggregatedCounts = poll.getVotes().stream()
                .collect(Collectors.groupingBy(
                        v -> String.valueOf(v.getVotesOn().getId()),
                        Collectors.collectingAndThen(Collectors.counting(), String::valueOf)
                ));

        redisPollCache.cachePollResults(pollIdLong, aggregatedCounts, POLL_CACHE_TTL);

        return aggregatedCounts;
    }
}
