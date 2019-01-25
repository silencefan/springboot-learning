package com.felixfan.learn.dao;

import com.felixfan.learn.entity.po.RechargeConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: TODO
 * @author: felix.fan
 * @date: 2019/1/14 11:32
 * @version: 1.0
 */
@Repository
public interface RechargeConfigRepository extends JpaRepository<RechargeConfig, Integer> {

    /**
     * 根据id查找充值配置
     *
     * @param id
     * @return
     */
    @Override
    RechargeConfig getOne(Integer id);

    /**
     * 查询所有充值记录
     * @return
     */
    @Override
    List<RechargeConfig> findAll();
}