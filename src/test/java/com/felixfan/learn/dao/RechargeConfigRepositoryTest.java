package com.felixfan.learn.dao;

import com.alibaba.fastjson.JSON;
import com.felixfan.learn.entity.po.RechargeConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @Description: 充值配置dao测试
 * @author: felix.fan
 * @date: 2019/1/14 11:34
 * @version: 1.0
 */
@RunWith(SpringRunner.class)
@MapperScan("com.felixfan.learn.mapper")
@SpringBootTest
@EnableCaching
public class RechargeConfigRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RechargeConfigRepository rechargeConfigRepository;

    @Autowired
    private RechargeService rechargeService;

    @Test
    public void testFindById() {
        for (int i = 0; i< 3; i ++) {
            RechargeConfig rechargeConfig = rechargeService.getRechargeConfig();
            logger.info("rechargeConfig = {}", JSON.toJSONString(rechargeConfig));
        }
    }

    @Test
    public void testFindAll() {
        List<RechargeConfig> rechargeConfigs = rechargeConfigRepository.findAll();
        rechargeConfigs.forEach((rechargeConfig -> logger.info("rechargeConfig = {}", JSON.toJSONString(rechargeConfig))));
    }
}