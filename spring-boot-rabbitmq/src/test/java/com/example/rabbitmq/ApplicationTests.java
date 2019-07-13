package com.example.rabbitmq;

import com.example.rabbitmq.direct.DirectSender;
import com.example.rabbitmq.fanout.FanoutSender;
import com.example.rabbitmq.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private DirectSender directSender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void contextLoads() {
        directSender.send("this is my msg......");
        topicSender.send("this is my msg......");
        fanoutSender.send("this is my msg......");
    }

}
