package com.acmday.springboot.server.extension.listener;

import com.acmday.springboot.server.extension.entity.MessageEntity;
import com.acmday.springboot.server.extension.event.BaseEvent;
import com.acmday.springboot.server.extension.event.SendMessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author acmday
 * @date 2022/11/7 上午12:05
 */
@Component
@Slf4j
public class MessageEventListener {

    @EventListener(classes = SendMessageEvent.class, condition = "#root.event.payload.tag==false ")
    public void messageNotice(BaseEvent<MessageEntity> message) {
        log.info("act=[MessageEventListener.messageNotice], message={}", message);
    }
}
