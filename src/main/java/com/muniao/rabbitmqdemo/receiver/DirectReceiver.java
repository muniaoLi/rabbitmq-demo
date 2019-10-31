package com.muniao.rabbitmqdemo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiver
{
    @RabbitListener(queues = "hello-queue")
    public void handler1(String msg)
    {
        System.out.println("DirectReceiver handler1:"+msg);
    }

    @RabbitListener(queues = "hello-queue")
    public void handler2(String msg)
    {
        System.out.println("DirectReceiver handler2:"+msg);
    }

}
