package com.felixfan.learn.dao;

import com.felixfan.learn.entity.po.RechargeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author: felix.fan
 * @date: 2019/1/24 20:40
 */
public class RechargeService implements IRechargeService {

    @Autowired
    private RechargeConfigRepository rechargeConfigRepository;

    @Override
    @Cacheable("rechargeConfig4")
    public RechargeConfig getRechargeConfig() {
        try {
            Thread.sleep(3000);
            System.out.println("查库中,休眠3秒。。。");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rechargeConfigRepository.getOne(2);
    }
}