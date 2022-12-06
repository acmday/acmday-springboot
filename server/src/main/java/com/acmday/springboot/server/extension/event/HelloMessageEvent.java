package com.acmday.springboot.server.extension.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @author acmday
 * @date 2022/12/5 下午11:44
 */
@Slf4j
public class HelloMessageEvent extends ApplicationEvent {

    /**
     *
     */
    public String name;

    public boolean status;

    public HelloMessageEvent(Object source, String name, boolean status) {
        super(source);
        this.name = name;
        this.status = status;
    }

    public HelloMessageEvent(Object source, Clock clock, String name, boolean status) {
        super(source, clock);
        this.name = name;
        this.status = status;
    }
}
