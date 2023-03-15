package com.acmday.springboot.server.extension.tmp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author acmday
 * @date 2022/11/7 上午12:05
 */
@Component
@Slf4j
public class MessageEventListener {

    @Async
    @EventListener(classes = SendMessageEvent.class, condition = "#root.event.payload.tag==false")
    public void messageNotice(SendMessageEvent event) {
        log.info("act=[MessageEventListener.messageNotice], message={}", event);
    }
}
