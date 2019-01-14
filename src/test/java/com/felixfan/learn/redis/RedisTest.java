package com.felixfan.learn.redis;

import com.alibaba.fastjson.JSON;
import com.felixfan.learn.entity.po.RechargeConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 测试redis
 * @author: felix.fan
 * @date: 2019/1/14 17:32
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testStringRedisTemplate() {
        //stringRedisTemplate.opsForValue().set("test", "试下中文2");
        stringRedisTemplate.opsForValue().set("testExpire", "message", 15, TimeUnit.SECONDS);
    }

    @Test
    public void testRedisTemplate() throws Exception {
        int currentTime = (int) (System.currentTimeMillis() / 1000);
        String key = "对象value";
        RechargeConfig rechargeConfig = new RechargeConfig(100, 10, currentTime, currentTime);
        rechargeConfig.setId(1);
        redisTemplate.opsForValue().set(key, rechargeConfig, 15, TimeUnit.SECONDS);

        Thread.sleep(7000);

        //get value
        RechargeConfig rechargeConfig2 = (RechargeConfig) redisTemplate.opsForValue().get(key);
        logger.info("key = {}, value = {}", key, JSON.toJSONString(rechargeConfig2));
    }
}