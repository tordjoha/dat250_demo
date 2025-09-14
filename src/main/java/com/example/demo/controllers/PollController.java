package com.example.demo.controllers;

import com.example.demo.dm.Poll;
import com.example.demo.dm.PollManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/polls")
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
    public List<Poll> getPolls() {
        return new ArrayList<>(pollManager.getAllPolls().values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable String id) {
        Poll poll = pollManager.getPoll(id);
        return poll != null ? ResponseEntity.ok(poll) : ResponseEntity.notFound().build();
    }
}
