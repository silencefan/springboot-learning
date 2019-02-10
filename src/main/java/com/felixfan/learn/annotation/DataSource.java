package com.felixfan.learn.annotation;

import java.lang.annotation.*;

/**
 * @author felix.fan
 * @date 2019/2/9 23:09
 * @description 切换数据注解 可以用于类或者方法级别 方法级别优先级 > 类级别
 */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    /**
     * 该值即key值
     * @return
     */
    String value() default "master";
}