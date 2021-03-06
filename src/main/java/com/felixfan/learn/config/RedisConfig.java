package com.felixfan.learn.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.time.Duration;

/**
 * @Description: Redis配置类
 * @author: felix.fan
 * @date: 2019/1/14 17:06
 * @version: 1.0
 */
@Configuration
public class RedisConfig {

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        //设置缓存1分钟
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1));
        return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory)).cacheDefaults(redisCacheConfiguration).build();
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(factory);
        return stringRedisTemplate;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        //解决键、值序列化问题
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer redisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        redisSerializer.setObjectMapper(objectMapper);
        template.setValueSerializer(redisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}