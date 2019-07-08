package com.example.rabbitmq.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.topic}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange.topic}", type = ExchangeTypes.TOPIC),
                key = "log.*.routing.key"
        )
)
public class TopicReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.err.println("TOPIC: " + msg);
    }

}
