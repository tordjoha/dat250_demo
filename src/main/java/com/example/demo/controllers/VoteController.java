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

    /*
    @PostMapping
    public void vote(@PathVariable String question, @RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String optionCaption = payload.get("option");
        var poll = pollManager.getPoll(question);
        if (poll == null) return;

        Object option = null;
        if (poll.options != null) {
            for (Object o : poll.options) {

                String caption = null;
                try {
                    caption = (String) o.getClass().getField("caption").get(o);
                } catch (Exception ignored) {
                }
                if (optionCaption != null && optionCaption.equals(caption)) {
                    option = o;
                    break;
                }
            }
        }
        if (option == null) return;

        votesByPoll.putIfAbsent(question, new HashMap<>());
    }


    @PutMapping
    public void vote(@PathVariable String question, @RequestBody Vote vote) {
        var poll = pollManager.getPoll(question);
        if (poll == null) return;

        Object option = null;
        if (poll.options != null) {
            for (Object o : poll.options) {

                String caption = null;
                try {
                    caption = (String) o.getClass().getField("caption").get(o);
                } catch (Exception ignored) {
                }
                if (vote.option != null && vote.option.equals(caption)) {
                    option = o;
                    break;
                }
            }
        }
        if (option == null) return;

        votesByPoll.putIfAbsent(question, new HashMap<>());
        votesByPoll.get(question).put(vote.username, vote);
    }

     */
}