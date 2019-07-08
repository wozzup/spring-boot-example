package com.example.rabbitmq.direct;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.exchange.direct}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange.direct}", type = ExchangeTypes.DIRECT),
                key = "${mq.config.queue.direct.routing.key}"
        )
)
public class DirectReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.err.println("DIRECT: " + msg);
    }

}
