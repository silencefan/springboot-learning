package com.felixfan.learn.service;

import com.felixfan.learn.entity.po.RechargeConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName RechargeServiceTest
 * @Author felix.fan
 * @Date 2019/1/16 0:10
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.felixfan.learn.mapper")
public class RechargeServiceTest {

    @Resource
    private IRechargeService rechargeService;

    @Test
    public void testQuery() {
        List<RechargeConfig> rechargeConfigs = rechargeService.queryList();
        System.out.println(rechargeConfigs);
    }
}