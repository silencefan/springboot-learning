package com.felixfan.learn.controller;

import com.felixfan.learn.dao.RechargeConfigRepository;
import com.felixfan.learn.entity.po.RechargeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 充值配置controller
 * @author: felix.fan
 * @date: 2019/1/14 20:57
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "/rechargeConfig")
public class RechargeController {

    @Autowired
    private RechargeConfigRepository rechargeConfigRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listRechargeConfig(Model model) {
        List<Object> list = new ArrayList<>();
        RechargeConfig rechargeConfig = rechargeConfigRepository.getOne(1);
        list.add(rechargeConfig);
        model.addAttribute("rechargeConfigs", list);
        return "/rechargeConfig";
    }
}