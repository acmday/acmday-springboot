package com.acmday.springboot.server.extension.event.listener.demo;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 5:38 下午
 */
@Component
@Slf4j
public class UserEventListenerAnnotation {

    @EventListener
    public void listenUserAddEvent(UserAddEvent event) {
        Object source = event.getSource();

        log.info("act=[UserEventListenerAnnotation] 收到消息,event={}, source={}",
            new Gson().toJson(event),
            source.getClass().getSimpleName());
    }
}
