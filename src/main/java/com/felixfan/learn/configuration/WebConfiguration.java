package com.felixfan.learn.configuration;

import com.felixfan.learn.filter.CustomFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WebConfiguration
 * @Description 配置对象类
 * @Author felix.fan
 * @Date 2019/1/13 22:30
 * @Version 1.0
 */
@Configuration
public class WebConfiguration {

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CustomFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("CustomFilter");
        registration.setOrder(1);
        return registration;
    }
}