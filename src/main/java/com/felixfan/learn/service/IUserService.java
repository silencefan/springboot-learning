package com.felixfan.learn.service;

import com.felixfan.learn.annotation.DataSource;
import com.felixfan.learn.entity.po.User;

import java.util.List;

/**
 * @Description: IUserService接口
 * @author: felix.fan
 * @date: 2019/1/8 15:25
 * @version: 1.0
 */
@DataSource("slave1")
public interface IUserService {

    /**
     * 新增用户(默认数据源)
     * @param user
     * @return
     */
    @DataSource
    int save(User user);

    /**
     * 更新用户信息(默认数据源)
     * @param user
     * @return
     */
    @DataSource("slave1")
    int update(User user);

    /**
     * 根据id删除(默认数据源)
     * @param id
     * @return
     */
    @DataSource
    int deleteById(Integer id);

    /**
     * 根据id查询(slave1数据源)
     * @param id
     * @return
     */
    @DataSource("slave1")
    User selectById(Integer id);

    /**
     * 查询所有用户信息(slave2数据源)
     * @return
     */
    @DataSource("slave2")
    List<User> selectAll();
}