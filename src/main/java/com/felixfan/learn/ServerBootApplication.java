package com.felixfan.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description: 服务启动类
 * @author: felix.fan
 * @date: 2019/1/8 13:50
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan("com.felixfan.learn.mapper")
@EnableSwagger2
public class ServerBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerBootApplication.class, args);
    }
}