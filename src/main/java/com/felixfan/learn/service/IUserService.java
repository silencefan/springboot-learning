package com.felixfan.learn.service;

import com.felixfan.learn.entity.vo.User;

/**
 * @Description: IUserService接口
 * @author: felix.fan
 * @date: 2019/1/8 15:25
 * @version: 1.0
 */
public interface IUserService {

    User findById(Integer id);
}