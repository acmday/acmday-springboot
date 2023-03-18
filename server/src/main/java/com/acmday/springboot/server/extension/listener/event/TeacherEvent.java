package com.acmday.springboot.server.extension.listener.event;

import com.acmday.springboot.server.extension.entity.Teacher;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 3:43 下午
 */
@Getter
public class TeacherEvent extends ApplicationEvent {

    private Teacher teacher;

    public TeacherEvent(Object source, Teacher teacher) {
        super(source);
        this.teacher = teacher;
    }
}
