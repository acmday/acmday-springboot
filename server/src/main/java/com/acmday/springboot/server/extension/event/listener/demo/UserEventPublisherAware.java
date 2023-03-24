package com.acmday.springboot.server.extension.event.listener.demo;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 5:40 下午
 */
@Component
public class UserEventPublisherAware implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishUserAddEvent(UserAddEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
