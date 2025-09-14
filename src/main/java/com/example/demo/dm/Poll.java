package com.example.demo.dm;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Poll
{
    private String id;
    private String question;
    private Instant publishedAt;
    private Instant validUntil;
    private List<Vote> votes = new ArrayList<>();

    public Poll() {
    }

    public Poll(String id, String question, Instant publishedAt, Instant validUntil) {
        this.id = id;
        this.question = question;
        this.publishedAt = publishedAt;
        this.validUntil = validUntil;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    public List<Vote> getVotes() {
        return votes;
    }
}
