package com.acmday.springboot.server.controller;

import com.acmday.springboot.server.bo.User;
import com.acmday.springboot.server.service.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author acmday.
 * @date 2020/4/16.
 */
@Slf4j
@RestController
@RequestMapping
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @RequestMapping("/echo")
    public String echo(String msg) {
        log.info("act=echo msg={}", msg);
        return helloService.echo(msg);
    }

    /**
     * @param user
     * @return
     * 测试链接：http://localhost:7003/convert?user=1587217358
     */
    @RequestMapping("/convert")
    public String convert(User user) {
        log.info("act=convert use.toString={}", user.toString());
        return user.toString();
    }
}
