package com.muniao.rabbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitFanoutConfig
{
    public final static String FANOUTNAME="lixp-fanout";

    @Bean
    FanoutExchange fanoutExchange()
    {
        return new FanoutExchange(FANOUTNAME, true, false);
    }

    @Bean
    Queue queueOne(){
        return new Queue("queue-one");
    }
    @Bean
    Queue queueTwo(){
        return new Queue("queue-two");
    }
    @Bean
    Binding bindOne()
    {
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }

    @Bean
    Binding bindTwo()
    {
        return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }

}
