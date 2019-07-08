package com.example.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange.fanout}")
    private String exchange;

    public void send(String msg) {
        amqpTemplate.convertAndSend(exchange, "", msg);
    }

}
