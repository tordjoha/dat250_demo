package com.example.demo.domain;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identifier;
    private String question;
    private Instant publishedAt;
    private Instant validUntil;
    private String topic;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vote> votes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VoteOption> options = new ArrayList<>();

    public Poll() {
    }

    public Poll(String identifier, String question, Instant publishedAt, Instant validUntil) {
        this.identifier = identifier;
        this.question = question;
        this.publishedAt = publishedAt;
        this.validUntil = validUntil;
        this.topic = "poll." + identifier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    /**
     *
     * Adds a new option to this Poll and returns the respective
     * VoteOption object with the given caption.
     * The value of the presentationOrder field gets determined
     * by the size of the currently existing VoteOptions for this Poll.
     * I.e. the first added VoteOption has presentationOrder=0, the secondly
     * registered VoteOption has presentationOrder=1 ans so on.
     */
    public VoteOption addVoteOption(String caption) {
        int order = options.size();
        VoteOption option = new VoteOption(caption, order);
        option.setPoll(this);
        options.add(option);
        return option;
    }

    public List<VoteOption> getOptions() {
        return options;
    }

    public boolean removeVoteOption(VoteOption option) {
        return options.remove(option);
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
