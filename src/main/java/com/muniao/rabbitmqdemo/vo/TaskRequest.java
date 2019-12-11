package com.muniao.rabbitmqdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest implements Serializable
{
    Long taskId;
    String taskCode;
}
