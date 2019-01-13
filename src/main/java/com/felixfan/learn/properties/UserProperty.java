package com.felixfan.learn.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserProperty
 * @Description User属性配置类
 * @Author felix.fan
 * @Date 2019/1/13 22:35
 * @Version 1.0
 */
@Data
@Component
public class UserProperty {

    @Value("${com.learn.author}")
    private String author;
}