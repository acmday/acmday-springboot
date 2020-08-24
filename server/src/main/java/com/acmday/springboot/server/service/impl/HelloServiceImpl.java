package com.acmday.springboot.server.service.impl;

import com.acmday.springboot.server.service.IHelloService;
import org.springframework.stereotype.Service;

/**
 * @author acmday.
 * @date 2020/4/16.
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Override
    public String echo(String msg) {
        return "echo:" + msg;
    }
}
