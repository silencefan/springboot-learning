package com.felixfan.learn.service;

import com.felixfan.learn.entity.po.RechargeConfig;

import java.util.List;

/**
 * @ClassName IRechargeService
 * @Author felix.fan
 * @Date 2019/1/15 23:48
 * @Version 1.0
 */
public interface IRechargeService {

    /**
     * 查询列表
     * @return
     */
    List<RechargeConfig> queryList();
}