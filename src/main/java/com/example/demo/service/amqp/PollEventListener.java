package com.example.demo.service.amqp;

import com.example.demo.service.PollManager;
import com.example.demo.events.VoteEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PollEventListener {

    private final PollManager pollManager;

    public PollEventListener(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @RabbitListener(queues = "${app.polls.app-queue}")
    public void onVote(VoteEvent event) {
        System.out.println("Received vote event in PollEventListener: " + event);
        pollManager.handleVoteEvent(event);
    }
}
