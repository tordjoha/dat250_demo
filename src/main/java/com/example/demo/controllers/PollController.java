package com.example.demo.controllers;

import com.example.demo.domain.Poll;
import com.example.demo.service.PollManager;
import com.example.demo.domain.VoteOption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/polls")
@CrossOrigin
public class PollController {

    private final PollManager pollManager;

    public PollController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        return pollManager.addPoll(poll);
    }

    @GetMapping()
    public Collection<Poll> getPolls() {
        return pollManager.getAllPolls().values();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable String id) {
        Poll poll = pollManager.getPoll(id);
        return poll != null ? ResponseEntity.ok(poll) : ResponseEntity.notFound().build();
    }


    @PostMapping("/{pollId}/options")
    public ResponseEntity<?> addOptionToPoll(@PathVariable String pollId, @RequestBody String caption) {
        Poll poll = pollManager.getPoll(pollId);
        if (poll == null) {
            return ResponseEntity.notFound().build();
        }
        VoteOption option = poll.addVoteOption(caption);
        return ResponseEntity.ok(option);
    }
}
