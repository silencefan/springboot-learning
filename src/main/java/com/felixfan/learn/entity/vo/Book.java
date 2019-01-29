package com.felixfan.learn.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author felix.fan
 * @Date 2019/1/29 0:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
    private String id;
    private String name;
}