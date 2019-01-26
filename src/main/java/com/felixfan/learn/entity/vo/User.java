package com.felixfan.learn.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: User对象
 * @author: felix.fan
 * @date: 2019/1/8 15:23
 * @version: 1.0
 */
@Data
@ApiModel
public class User {

    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("年龄")
    private Integer age;
}