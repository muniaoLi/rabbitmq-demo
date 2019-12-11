package com.muniao.rabbitmqdemo;

import com.muniao.rabbitmqdemo.config.RabbitFanoutConfig;
import com.muniao.rabbitmqdemo.config.RabbitTopicConfig;
import com.muniao.rabbitmqdemo.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqDemoApplicationTests
{
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void directTest()
    {

        rabbitTemplate.convertAndSend("hello-queue", new UserVO("lixp",30));

    }

    @Test
    void fanoutTest()
    {
        rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTNAME, null, "hello fanout!");
    }

    @Test
    void topicTest()
    {
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "xiaomi.news", "小米新闻。。。");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "huawei.news", "华为新闻。。。");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "xiaomi.phone", "小米手机。。。");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "huawei.phone", "华为手机。。。");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME, "phone.news", "手机新闻。。。");
    }

}
