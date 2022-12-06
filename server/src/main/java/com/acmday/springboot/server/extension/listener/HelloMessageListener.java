package com.acmday.springboot.server.extension.listener;

import com.acmday.springboot.server.extension.event.HelloMessageEvent;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author acmday
 * @date 2022/12/5 下午11:53
 */
@Component
@Slf4j
public class HelloMessageListener {

    private static final Gson GSON = new Gson();

    @EventListener(classes = HelloMessageEvent.class, condition = "#root.event.status==true")
    public void listen(HelloMessageEvent event) {
        log.info("act=[HelloMessageListener.listen] event={}", GSON.toJson(event));
    }
}
