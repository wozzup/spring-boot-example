package com.example.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange.topic}")
    private String exchange;

    @Value("${mq.config.queue.topic.routing.key}")
    private String routingKey;

    public void send(String msg) {
        amqpTemplate.convertAndSend(exchange, routingKey, msg);
    }

}
