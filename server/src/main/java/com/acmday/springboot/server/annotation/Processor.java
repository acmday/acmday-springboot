package com.acmday.springboot.server.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author wushaofeng
 * @Date 2023/4/13 1:46 下午
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Processor {

    String groupName();

    int order();
}