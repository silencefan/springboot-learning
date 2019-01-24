package com.felixfan.learn.entity.vo;

import lombok.Data;

/**
 * @Description: User对象
 * @author: felix.fan
 * @date: 2019/1/8 15:23
 * @version: 1.0
 */
@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private Integer sex;

    private Integer age;
}