package com.acmday.springboot.server.spring;

import com.acmday.springboot.server.BaseTest;
import com.acmday.springboot.server.extension.a.UserAddEvent;
import com.acmday.springboot.server.extension.a.UserEventPublisher;
import com.acmday.springboot.server.extension.a.UserEventPublisherContext;
import com.acmday.springboot.server.extension.a.UserInfo;
import com.acmday.springboot.server.extension.entity.Teacher;
import com.acmday.springboot.server.extension.listener.TeacherEventListener;
import com.acmday.springboot.server.extension.listener.TeacherPublisher;
import com.acmday.springboot.server.extension.listener.event.TeacherEvent;
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
    private TeacherPublisher teacherPublisher;
    @Resource
    private UserEventPublisherContext userEventPublisherContext;
    @Resource
    private UserEventPublisher userEventPublisher;

    @Test
    public void publishEvent() {
        teacherPublisher.publishEvent(new TeacherEvent(this, new Teacher()));
    }

    @Test
    public void publishUserAddEvent() {
        UserInfo user = new UserInfo();
        user.setAge(18);
        user.setName("ocean");

        UserAddEvent event = new UserAddEvent(this, user);
        userEventPublisherContext.publishUserAddEvent(event);
    }

    @Test
    public void ff() {
        UserInfo user = new UserInfo();
        user.setAge(18);
        user.setName("ocean");

        UserAddEvent event = new UserAddEvent(this, user);
        userEventPublisher.publishUserAddEvent(event);
    }


}
