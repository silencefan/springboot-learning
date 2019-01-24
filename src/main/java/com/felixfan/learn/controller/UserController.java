package com.felixfan.learn.controller;

import com.alibaba.fastjson.JSON;
import com.felixfan.learn.entity.vo.User;
import com.felixfan.learn.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: user controller
 * @author: felix.fan
 * @date: 2019/1/8 15:22
 * @version: 1.0
 */
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user.find/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        logger.info("test UserProperty author = {}", user.getUsername());
        return JSON.toJSONString(user);
    }
}