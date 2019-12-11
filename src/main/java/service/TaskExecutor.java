package service;

import com.muniao.rabbitmqdemo.vo.TaskRequest;
import com.muniao.rabbitmqdemo.vo.TaskResponse;

public interface TaskExecutor
{
    TaskResponse execute(TaskRequest request);
}
