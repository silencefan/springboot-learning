package com.felixfan.learn.service.impl;

import com.felixfan.learn.entity.po.User;
import com.felixfan.learn.mapper.UserMapper;
import com.felixfan.learn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: IUserService接口实现类
 * @author: felix.fan
 * @date: 2019/1/8 15:22
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectAll() {
        return null;
    }
}