package com.example.demo.service;

public interface BrokerService {
    /** Register a topic with the broker */
    void createTopic(String topicName);

    /** Publish an event to the named topic */
    void publish(String topicName, Object event);
}
