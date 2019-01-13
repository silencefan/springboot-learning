package com.felixfan.learn.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName CustomFilter
 * @Description 自定义过滤器
 * @Author felix.fan
 * @Date 2019/1/13 22:29
 * @Version 1.0
 */
public class CustomFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("CustomFilter start init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("CustomFilter start doFilter...");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        logger.info("this is CustomFilter, url = {}", request.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("CustomFilter start destroy...");
    }
}