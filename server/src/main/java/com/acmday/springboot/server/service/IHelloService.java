package com.acmday.springboot.server.service;

/**
 * @author acmday.
 * @date 2020/4/16.
 */
public interface IHelloService {

    /**
     * @param msg
     * @return
     */
    String echo(String msg);

    int getType();
}
