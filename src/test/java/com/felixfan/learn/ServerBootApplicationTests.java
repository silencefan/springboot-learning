package com.felixfan.learn;

import com.felixfan.learn.properties.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.felixfan.learn.mapper")
public class ServerBootApplicationTests {

    @Autowired
    private Author author;

    @Test
    public void testProperties() {
        System.out.println(author.getAuthor());
    }
}

