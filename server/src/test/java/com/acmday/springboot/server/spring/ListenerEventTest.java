package com.acmday.springboot.server.spring;

import com.acmday.springboot.server.BaseTest;
import com.acmday.springboot.server.extension.event.listener.demo.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 3:53 下午
 */
@Slf4j
public class ListenerEventTest extends BaseTest {

    @Resource
    private UserEventPublisherContext userEventPublisherContext;
    @Resource
    private UserEventPublisher userEventPublisher;
    @Resource
    private UserEventPublisherAware userEventPublisherAware;

    @Test
    public void applicationContext() {
        UserInfo user = new UserInfo();
        user.setAge(18);
        user.setName("ocean");

        UserAddEvent event = new UserAddEvent(this, user);
        userEventPublisherContext.publishUserAddEvent(event);
    }

    @Test
    public void applicationEventPublisher() {
        UserInfo user = new UserInfo();
        user.setAge(18);
        user.setName("ocean");

        UserAddEvent event = new UserAddEvent(this, user);
        userEventPublisher.publishUserAddEvent(event);
    }

    @Test
    public void applicationEventPublisherAware() {
        UserInfo user = new UserInfo();
        user.setAge(18);
        user.setName("ocean");

        UserAddEvent event = new UserAddEvent(this, user);
        userEventPublisherAware.publishUserAddEvent(event);
    }

}
