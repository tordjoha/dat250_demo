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
    private List<VoteOption> options = new ArrayList<>();

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
        options.add(option);
        return option;
    }

    public List<VoteOption> getOptions() {
        return options;
    }

    public boolean removeVoteOption(VoteOption option) {
        return options.remove(option);
    }
}
