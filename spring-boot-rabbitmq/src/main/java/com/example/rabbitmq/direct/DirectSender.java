package com.example.rabbitmq.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DirectSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange.direct}")
    private String exchange;

    @Value("${mq.config.queue.direct.routing.key}")
    private String routingKey;

    public void send(String msg) {
        amqpTemplate.convertAndSend(exchange, routingKey, msg);
    }

}
