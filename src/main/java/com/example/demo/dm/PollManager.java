package com.example.demo.dm;

import com.example.demo.amqp.BrokerService;
import com.example.demo.events.VoteEvent;
import com.example.demo.service.RedisPollCache;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class PollManager {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Poll> polls = new HashMap<>();
    private final RedisPollCache redisPollCache;
    private final BrokerService brokerService;
    private static final long POLL_CACHE_TTL = 600; // 10 minutes

    public PollManager(RedisPollCache redisPollCache, BrokerService brokerService) {
        this.redisPollCache = redisPollCache;
        this.brokerService = brokerService;
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
        brokerService.createTopic(poll.getTopic());
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
        VoteEvent event = new VoteEvent(Long.valueOf(pollId),
                vote.getVotesOn().getId(),
                vote.getId());
        brokerService.publish(poll.getTopic(), event);
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

    public void handleVoteEvent(VoteEvent event) {
        Poll poll = polls.get(String.valueOf(event.getPollId()));
        if (poll == null) {
            System.err.println("Poll not found for vote event: " + event.getPollId());
            return;
        }

        VoteOption option = poll.getOptions().stream()
                .filter(o -> o.getId().equals(event.getOptionId()))
                .findFirst()
                .orElse(null);

        if (option == null) {
            System.err.println("Option not found for vote event: " + event.getOptionId());
            return;
        }

        Vote vote = new Vote();
        vote.setVotesOn(option);
        vote.setId(event.getUserId());
        poll.getVotes().add(vote);

        redisPollCache.invalidatePoll(Long.valueOf(poll.getIdentifier()));
        System.out.println("Vote event applied for poll " + poll.getIdentifier());
    }
}
