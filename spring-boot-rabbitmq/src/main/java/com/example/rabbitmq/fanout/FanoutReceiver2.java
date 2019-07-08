package com.example.rabbitmq.fanout;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.sms}", autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange.fanout}", type = ExchangeTypes.FANOUT)
        )
)
public class FanoutReceiver2 {

    @RabbitHandler
    public void process(String msg) {
        System.err.println("FANOUT2: " + msg);
    }

}
