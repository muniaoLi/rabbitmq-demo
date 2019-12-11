package com.muniao.rabbitmqdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestVO implements Serializable
{
    Long id;
    String name;
    Integer age;
    String taskCode;
    String taskId;
}
