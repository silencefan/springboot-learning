package com.felixfan.learn.controller;

import com.felixfan.learn.config.RabbitConfig;
import com.felixfan.learn.config.RabbitMQConfig;
import com.felixfan.learn.entity.vo.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @Author felix.fan
 * @Date 2019/1/29 0:12
 */
@Slf4j
@RestController
@RequestMapping(value = "/books")
public class BookController {

    private static RabbitTemplate rabbitTemplate;

    @Autowired
    public BookController (RabbitTemplate rabbitTemplate) {
        BookController.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping
    public void defaultMessage() {
        Book book = new Book("1", "一起来学SpringBoot RabbitMQ");
//        rabbitTemplate.convertAndSend(RabbitMQConfig.DEFAULT_BOOK_QUEUE, book);
//        rabbitTemplate.convertAndSend(RabbitMQConfig.MANUAL_BOOK_QUEUE, book);
        rabbitTemplate.convertAndSend(RabbitConfig.REGISTER_DELAY_EXCHANGE, RabbitConfig.DELAY_ROUTING_KEY, book, message -> {
            // TODO 第一句是可要可不要,根据自己需要自行处理
            message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, Book.class.getName());
            // TODO 如果配置了 params.put("x-message-ttl", 5 * 1000); 那么这一句也可以省略,具体根据业务需要是声明 Queue 的时候就指定好延迟时间还是在发送自己控制时间
            message.getMessageProperties().setExpiration(5 * 1000 + "");
            return message;
        });
        log.info("[发送时间] - [{}]", LocalDateTime.now());
    }
}