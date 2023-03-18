package com.acmday.springboot.server.extension.a;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 5:41 下午
 */

@Component
public class UserEventPublisher {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishUserAddEvent(UserAddEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

}
