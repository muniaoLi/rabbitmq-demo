package com.muniao.rabbitmqdemo.receiver;

import com.muniao.rabbitmqdemo.util.TaskExecutorSelectUtil;
import com.muniao.rabbitmqdemo.vo.RequestVO;
import com.muniao.rabbitmqdemo.vo.TaskRequest;
import com.muniao.rabbitmqdemo.vo.TaskResponse;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import service.TaskExecutor;

/**
 * 消息消费者
 */
@Component
public class MessageConsumer
{
    @RabbitListener(queues = "test_queue")
    public void handler(RequestVO request)
    {
        System.out.println("DirectReceiver handler:" + request.toString());
        String taskCode = request.getTaskCode();
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskId(request.getId());
        taskRequest.setTaskCode(taskCode);

        TaskExecutor taskExecutor = TaskExecutorSelectUtil.getTaskExecutorByTaskCode(taskCode);
        TaskResponse response = taskExecutor.execute(taskRequest);
        System.out.println("execute result: "+response);
    }

}
