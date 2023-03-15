package com.acmday.springboot.server.spring;

import com.acmday.springboot.server.BaseTest;
import com.acmday.springboot.server.extension.entity.MessageEntity;
import com.acmday.springboot.server.extension.tmp.HelloMessageEvent;
import com.acmday.springboot.server.extension.tmp.SendMessageEvent;
import com.acmday.springboot.server.extension.tmp.HelloMessageListener;
import com.acmday.springboot.server.extension.tmp.MessageEventListener;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author acmday
 * @date 2022/12/5 下午11:30
 */
@Slf4j
public class MessageEventListenerTest extends BaseTest {

    @Test
    public void publishEvent() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloMessageListener.class);
        HelloMessageEvent event = new HelloMessageEvent(new Object(), "事件1", true);
        //判断当前ApplicationContext有没有父级 ，如果有则执行父级调用publishEvent 否则ApplicationListener会被多次执行
        if (context.getParent() != null) {
            context.publishEvent(event);
        }
        log.info("act=[publishEvent] event={}", new Gson().toJson(event));
        context.close();
    }

    @Test
    public void sendMessageEvent() {
        MessageEntity message = MessageEntity.builder()
                .messageId(2L)
                .content("applicationContextPublish.test")
                .tag(true)
                .build();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MessageEventListener.class);
        SendMessageEvent event = new SendMessageEvent(new Object(), message);
        context.publishEvent(event);
        log.info("act=[sendMessageEvent] event={}", new Gson().toJson(event));
        context.close();
    }
}
