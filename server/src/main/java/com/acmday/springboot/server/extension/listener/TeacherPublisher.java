package com.acmday.springboot.server.extension.listener;

import com.acmday.springboot.server.extension.entity.Teacher;
import com.acmday.springboot.server.extension.listener.event.TeacherEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 3:46 下午
 */
@Slf4j
@Component
public class TeacherPublisher {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(TeacherEvent event) {
//        Teacher teacher = Teacher.builder()
//            .id(10010L)
//            .name("ocean")
//            .build();
        applicationEventPublisher.publishEvent(event);
        log.info("act=[TeacherPublisher#publishEvent] 事件发布完成！");
    }
}
