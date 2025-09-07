package com.example.demo.controllers;

import com.example.demo.dm.PollManager;
import com.example.demo.dm.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/polls/{question}/vote")
public class VoteController {
    private final Map<String, Map<String, Vote>> votesByPoll = new HashMap<>();
    private final PollManager pollManager;

    @Autowired
    public VoteController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public void vote(@PathVariable String question, @RequestBody Map<String, String> payload)
}
