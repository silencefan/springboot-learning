package com.felixfan.learn.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: felix.fan
 * @date: 2019/1/24 15:09
 */
@Component
@Data
@PropertySource("classpath:/config/user.properties")
@ConfigurationProperties(prefix = "com.learn")
public class Author {

    /*
     @PropertySource注解指明properties文件所在的路径
     @ConfigurationProperties注解指明属性的前缀
     */

    private String author;
}