package com.muniao.rabbitmqdemo.util;

import com.muniao.rabbitmqdemo.annotation.TaskCode;
import com.muniao.rabbitmqdemo.context.ApplicationContextRegist;
import org.springframework.context.ApplicationContext;
import service.TaskExecutor;

import java.util.HashMap;
import java.util.Map;

public class TaskExecutorSelectUtil
{
    private static Map<String, TaskExecutor> taskExecutorMap;

    public static TaskExecutor getTaskExecutorByTaskCode(String taskCode)
    {
        if (taskExecutorMap == null)
            taskExecutorMap = initTaskExecutorMap();
        return taskExecutorMap.get(taskCode);
    }

    private static synchronized Map<String, TaskExecutor> initTaskExecutorMap()
    {
        if (taskExecutorMap != null)
            return taskExecutorMap;

        Map<String, TaskExecutor> taskMap = new HashMap<String, TaskExecutor>();
        ApplicationContext applicationContext = ApplicationContextRegist.getApplicationContext();
        Map<String, Object> maps = applicationContext.getBeansWithAnnotation(TaskCode.class);
        for (Object bean : maps.values())
        {
            TaskCode taskCode = bean.getClass().getAnnotation(TaskCode.class);
            if (bean instanceof TaskExecutor)
            {
                for (String taskCodeStr : taskCode.value())
                    taskMap.put(taskCodeStr, (TaskExecutor) bean);
            }
        }

        return taskMap;
    }

}
