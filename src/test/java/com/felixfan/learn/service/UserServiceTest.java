package com.felixfan.learn.service;

import com.alibaba.fastjson.JSON;
import com.felixfan.learn.config.DynamicDataSourceRegister;
import com.felixfan.learn.entity.po.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @author felix.fan
 * @date 2019/2/10 0:06
 * @description
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Import({DynamicDataSourceRegister.class})
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@MapperScan("com.felixfan.learn.mapper")
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void save() {
        User user = new User();
        user.setUsername("master");
        user.setPassword("master");
        user.setSex((byte) 1);
        user.setAge(18);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(8);
        user.setPassword("newpassword");
        // 返回插入的记录数 ，期望是1条 如果实际不是一条则抛出异常
    }

    @Test
    public void selectById() {
        User user = userService.selectById(2);
        log.info("user: {}", JSON.toJSONString(user));
    }

    @Test
    public void deleteById() {
        log.info("delete result: {}", userService.deleteById(1));
    }

    @Test
    public void selectAll() {
        List<User> users = userService.selectAll();
        users.forEach(user -> log.info("user: {}", JSON.toJSONString(user)));
    }

//    @Test
//    public void testTransactional() {
//        userService.testTransactional();
//    }
}