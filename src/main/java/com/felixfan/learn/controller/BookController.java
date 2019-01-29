package com.felixfan.learn.controller;

import com.felixfan.learn.config.RabbitMQConfig;
import com.felixfan.learn.entity.vo.Book;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author felix.fan
 * @Date 2019/1/29 0:12
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public void defaultMessage() {
        Book book = new Book("1", "一起来学SpringBoot RabbitMQ");
        rabbitTemplate.convertAndSend(RabbitMQConfig.DEFAULT_BOOK_QUEUE, book);
        rabbitTemplate.convertAndSend(RabbitMQConfig.MANUAL_BOOK_QUEUE, book);
    }
}