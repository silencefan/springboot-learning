package com.felixfan.learn.controller;

import com.alibaba.fastjson.JSON;
import com.felixfan.learn.entity.vo.User;
import com.felixfan.learn.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: user controller
 * @author: felix.fan
 * @date: 2019/1/8 15:22
 * @version: 1.0
 */
@RestController
@Api(description = "用户管理", value = "用户管理")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/user.find/{id}")
    @ApiOperation(value = "根据id查询")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Integer", paramType = "path")
    public String findById(@PathVariable(value = "id") Integer id) {
        User user = userService.findById(id);
        logger.info("test UserProperty author = {}", user.getUsername());
        return JSON.toJSONString(user);
    }
}