package com.example.demo.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant publishedAt;

    @ManyToOne
    @JoinColumn(name = "option_id", nullable = false)
    private VoteOption votesOn;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User createdBy;

    public Vote() {
    }

    public Vote(Instant publishedAt, VoteOption votesOn, User createdBy) {
        this.publishedAt = publishedAt;
        this.votesOn = votesOn;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public VoteOption getVotesOn() {
        return votesOn;
    }

    public void setVotesOn(VoteOption votesOn) {
        this.votesOn = votesOn;
    }
}
