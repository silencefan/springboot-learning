package com.felixfan.learn.service.impl;

import com.felixfan.learn.entity.vo.User;
import com.felixfan.learn.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Description: IUserService接口实现类
 * @author: felix.fan
 * @date: 2019/1/8 15:22
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("唐伯虎");
        user.setSex('男');
        return user;
    }
}