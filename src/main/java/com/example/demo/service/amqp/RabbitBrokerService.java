package com.example.demo.service.amqp;

import com.example.demo.service.BrokerService;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitBrokerService implements BrokerService {
    private final AmqpAdmin amqpAdmin;
    private final Queue appQueue;
    private final RabbitTemplate rabbitTemplate;

    public RabbitBrokerService(AmqpAdmin amqpAdmin, Queue appQueue, RabbitTemplate rabbitTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.appQueue = appQueue;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void createTopic(String topicName) {
        TopicExchange exchange = new TopicExchange(topicName, true, false);
        amqpAdmin.declareExchange(exchange);

        // Bind the global app queue to the new exchange with '#' so we receive everything
        Binding binding = BindingBuilder.bind(appQueue).to(exchange).with("#");
        amqpAdmin.declareBinding(binding);
    }

    @Override
    public void publish(String topicName, Object event) {
        rabbitTemplate.convertAndSend(topicName, "vote", event);
    }
}
