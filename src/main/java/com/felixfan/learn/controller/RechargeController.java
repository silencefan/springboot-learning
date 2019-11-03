package com.felixfan.learn.controller;

import com.felixfan.learn.dao.RechargeConfigRepository;
import com.felixfan.learn.entity.po.RechargeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 充值配置controller
 * @author: felix.fan
 * @date: 2019/1/14 20:57
 * @version: 1.0
 */
@Controller
@RequestMapping(value = "/rechargeConfig")
public class RechargeController {

    @Autowired
    private RechargeConfigRepository rechargeConfigRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @RequestMapping(value = "/list/{receiver}", method = RequestMethod.GET)
    public String listRechargeConfig(@PathVariable(name = "receiver") String receiver) throws Exception {
//        List<Object> list = new ArrayList<>();
//        RechargeConfig rechargeConfig = rechargeConfigRepository.getOne(1);
//        list.add(rechargeConfig);
//        model.addAttribute("rechargeConfigs", list);
        testSendSimpleMail(receiver);
        return "/chatRoom";
    }

    private void testSendSimpleMail(String receiver) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(receiver);
        message.setSubject("主题：测试邮件发送的主题");
        message.setText("测试邮件内容");
        javaMailSender.send(message);
    }
}