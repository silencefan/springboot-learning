package com.felixfan.learn.service.impl;

import com.felixfan.learn.entity.po.RechargeConfig;
import com.felixfan.learn.mapper.RechargeConfigMapper;
import com.felixfan.learn.service.IRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RechargeServiceImpl
 * @Author felix.fan
 * @Date 2019/1/15 23:50
 * @Version 1.0
 */
public class RechargeServiceImpl implements IRechargeService {

    @Autowired
    private RechargeConfigMapper rechargeConfigMapper;

    @Override
    public List<RechargeConfig> queryList() {
        List<RechargeConfig> rechargeConfigs = rechargeConfigMapper.selectAll();
        return rechargeConfigs;
    }
}
