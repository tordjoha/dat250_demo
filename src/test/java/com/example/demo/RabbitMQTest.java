package com.example.demo;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.nio.charset.StandardCharsets;

public class RabbitMQTest {
    private final static String EXCHANGE_NAME = "poll.myid";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);

            String message = "{\"pollId\":1,\"optionId\":2,\"userId\":null}";
            String routingKey = "vote";

            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
        }
    }
}
