package com.example.rabbitmq.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.topic2}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange.topic}", type = ExchangeTypes.TOPIC),
                key = "*.*.*.*"
        )
)
public class TopicReceiver2 {

    @RabbitHandler
    public void process(String msg) {
        System.err.println("TOPIC2: " + msg);
    }

}
