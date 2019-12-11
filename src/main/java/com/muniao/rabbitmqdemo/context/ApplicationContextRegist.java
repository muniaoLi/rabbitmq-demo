package com.muniao.rabbitmqdemo.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class ApplicationContextRegist implements ApplicationContextAware
{
    private static ApplicationContext applicationContext;
    public static ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        ApplicationContextRegist.applicationContext = applicationContext;
    }
}
