package com.acmday.springboot.server.extension.a;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 5:40 下午
 */
public class UserEventPublisherInterface implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishUserAddEvent(UserAddEvent event) {
        applicationEventPublisher.publishEvent(event);
    }
}
