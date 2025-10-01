package com.example.demo.config;

import redis.clients.jedis.UnifiedJedis;

public class Main {
    public static void main(String[] args) {
        // Connect to Redis running locally on port 6379
        UnifiedJedis jedis = new UnifiedJedis("redis://localhost:6379");

        try {
            jedis.set("test-key", "Hello Redis!");
            String value = jedis.get("test-key");
            System.out.println("Redis says: " + value);
            jedis.del("test-key");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }
}
