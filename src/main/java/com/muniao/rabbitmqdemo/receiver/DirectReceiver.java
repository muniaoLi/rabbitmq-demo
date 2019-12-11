package com.muniao.rabbitmqdemo.receiver;

import com.muniao.rabbitmqdemo.vo.UserVO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiver
{
    @RabbitListener(queues = "hello-queue")
    public void handler1(UserVO user)
    {
        System.out.println("DirectReceiver handler1:"+user.toString());
    }

   /* @RabbitListener(queues = "hello-queue")
    public void handler2(String msg)
    {
        System.out.println("DirectReceiver handler2:"+msg);
    }
*/
}
