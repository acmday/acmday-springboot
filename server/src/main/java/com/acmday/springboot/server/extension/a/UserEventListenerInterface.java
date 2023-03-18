package com.acmday.springboot.server.extension.a;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 5:37 下午
 */
@Component
@Slf4j
public class UserEventListenerInterface implements ApplicationListener<UserAddEvent> {

    @Override
    public void onApplicationEvent(UserAddEvent event) {
        Object source = event.getSource();
        log.info("act=[UserEventListenerInterface#onApplicationEvent] 收到消息,event={}, source={}",
            new Gson().toJson(event),
            source.getClass().getSimpleName());
    }
}
