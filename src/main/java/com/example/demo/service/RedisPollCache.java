package com.example.demo.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RedisPollCache {

    private final RedisTemplate<String, Object> redisTemplate;
    private final HashOperations<String, String, String> hashOps;

    public RedisPollCache(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOps = redisTemplate.opsForHash();
    }

    private String pollKey(Long pollId) {
        return "poll:" + pollId;
    }

    public Map<String, String> getPollResults(Long pollId) {
        return hashOps.entries(pollKey(pollId));
    }

    public void cachePollResults(Long pollId, Map<String, String> results, long ttlSeconds) {
        String key = pollKey(pollId);
        hashOps.putAll(key, results);
        redisTemplate.expire(key, ttlSeconds, TimeUnit.SECONDS);
    }

    public void invalidatePoll(Long pollId) {
        redisTemplate.delete(pollKey(pollId));
    }
}
