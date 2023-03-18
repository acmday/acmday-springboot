package com.acmday.springboot.server.extension.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 5:33 下午
 */
@Component
public class UserEventPublisherContext {

    @Resource
    private ApplicationContext applicationContext;

    public void publishUserAddEvent(UserAddEvent event) {
        applicationContext.publishEvent(event);
    }

    public void publishUserDelEvent(UserDelEvent event) {
        applicationContext.publishEvent(event);
    }
}