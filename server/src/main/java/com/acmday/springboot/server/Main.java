package com.acmday.springboot.server;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author acmday.
 * @date 2020/4/16.
 */
@SpringBootApplication
@Slf4j
@ComponentScan("com.acmday.springboot")
@MapperScan(basePackages = {"com.acmday.springboot.dao.mapper"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        log.info("——————————————springboot success!!!——————————————");
    }
}
