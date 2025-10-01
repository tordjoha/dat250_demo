# Experiment 5: Redis

- I chose the datatype Hash datatype to store the poll voting data. The reason being easy key value access as well as
incrementation

- First I make sure the local Redis server is running before connecting to it from Java. The port is 6379 by default.
    ```bash
    redis-server $(brew --prefix)/etc/redis.conf
    ```

- To ensure the Poll entry is "invalidated" in the cache when a vote is made, I delete the entry from Redis. 
This way the next read will fetch the newest count data from Redis.
    ```bash
    redisTemplate.delete("poll:" + pollId);
    ```
- Created a RedisConfig class to configure the RedisTemplate bean.
- Created a RedisPollCache class to handle the caching operations.
- Made changes to PollManager's operations to include the caching logic.

## Technical problems
- When trying to implement the Hash datatype I had some trouble getting it imported and working. Found out that the
``implementation("redis.clients:jedis:6.2.0")`` only imports the client and not the operations I was after. After adding
``implementation("org.springframework.boot:spring-boot-starter-data-redis")`` in *build.gradle.kts* it worked.


## Pending issues
No (known) pending issues with this new implementation of a cache layer.