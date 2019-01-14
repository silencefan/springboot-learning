package com.felixfan.learn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Description: redis session配置
 * @author: felix.fan
 * @date: 2019/1/14 20:04
 * @version: 1.0
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60)
public class RedisSessionConfig {
}