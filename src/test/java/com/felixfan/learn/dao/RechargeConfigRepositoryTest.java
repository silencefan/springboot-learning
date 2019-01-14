package com.felixfan.learn.dao;

import com.alibaba.fastjson.JSON;
import com.felixfan.learn.entity.po.RechargeConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Description: 充值配置dao测试
 * @author: felix.fan
 * @date: 2019/1/14 11:34
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RechargeConfigRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private RechargeConfigRepository rechargeConfigRepository;

    @Test
    public void testFindById() {
        RechargeConfig rechargeConfig = rechargeConfigRepository.getOne(2);
        logger.info("rechargeConfig = {}", JSON.toJSONString(rechargeConfig));
    }
}