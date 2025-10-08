package com.example.demo.controllers;

import com.example.demo.service.PollManager;
import com.example.demo.domain.Vote;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/polls/{pollId}/vote")
@CrossOrigin
public class VoteController {

    private final PollManager pollManager;

    public VoteController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public Vote castVote(@PathVariable String pollId) {
        Vote vote = new Vote();
        vote.setPublishedAt(Instant.now());
        return pollManager.addVote(pollId, vote);
    }

    @GetMapping
    public Map<String, String> getVotes(@PathVariable String pollId) {
        return pollManager.getVotes(pollId);
    }

}