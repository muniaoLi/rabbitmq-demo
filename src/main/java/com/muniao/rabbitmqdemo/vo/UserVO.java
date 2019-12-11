package com.muniao.rabbitmqdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserVO implements Serializable
{
    String name;
    int age;
}
