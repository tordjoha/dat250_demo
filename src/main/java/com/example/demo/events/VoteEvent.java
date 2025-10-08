package com.example.demo.events;

public class VoteEvent {
    private Long pollId;
    private Long optionId;
    private Long userId; // nullable -> anonymous vote

    public VoteEvent() {}

    public VoteEvent(Long pollId, Long optionId, Long userId) {
        this.pollId = pollId;
        this.optionId = optionId;
        this.userId = userId;
    }

    public Long getPollId() { return pollId; }
    public void setPollId(Long pollId) { this.pollId = pollId; }

    public Long getOptionId() { return optionId; }
    public void setOptionId(Long optionId) { this.optionId = optionId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
