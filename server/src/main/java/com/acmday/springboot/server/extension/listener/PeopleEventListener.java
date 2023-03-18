package com.acmday.springboot.server.extension.listener;

import com.acmday.springboot.server.extension.listener.event.TeacherEvent;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 5:03 下午
 */
@Slf4j
@Component
public class PeopleEventListener implements ApplicationListener<TeacherEvent> {

    private static final Gson GSON = new Gson();

    @Override
    public void onApplicationEvent(TeacherEvent event) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("act=[TeacherEventListener#handleEvent] event={}", GSON.toJson(event));
    }
}
