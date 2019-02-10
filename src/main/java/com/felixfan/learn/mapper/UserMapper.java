package com.felixfan.learn.mapper;

import com.felixfan.learn.entity.po.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {
}