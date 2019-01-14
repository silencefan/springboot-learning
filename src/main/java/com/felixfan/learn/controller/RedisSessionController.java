package com.felixfan.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 测试分布式Session共享
 * @author: felix.fan
 * @date: 2019/1/14 20:24
 * @version: 1.0
 */
@RestController
@RequestMapping(value = "/testSession")
public class RedisSessionController {

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public Map<String, Object> firstRequest(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(16);
        request.getSession().setAttribute("request url", request.getRequestURL());
        map.put("request url", request.getRequestURL());
        return map;
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public Object session(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("request url"));
        return map;
    }
}