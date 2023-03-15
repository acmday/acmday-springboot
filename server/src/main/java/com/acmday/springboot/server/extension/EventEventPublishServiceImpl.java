package com.acmday.springboot.server.extension;

import com.acmday.springboot.server.extension.entity.MessageEntity;
import com.acmday.springboot.server.extension.tmp.SendMessageEvent;
import com.acmday.springboot.server.service.IEventPublishService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author acmday
 * @date 2022/11/6 下午11:50
 */
@Service
public class EventEventPublishServiceImpl implements IEventPublishService {

    @Resource
    private ApplicationContext applicationContext;

    private final ApplicationEventPublisher publisher;

    public EventEventPublishServiceImpl(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishEvent() {
        MessageEntity message = MessageEntity.builder()
                .messageId(2L)
                .content("applicationContextPublish.test")
                .tag(true)
                .build();
        publisher.publishEvent(new SendMessageEvent(this, message));
    }


    public void applicationContextPublish() {
        MessageEntity message = MessageEntity.builder()
                .messageId(1L)
                .content("applicationContextPublish.test")
                .tag(false)
                .build();
        applicationContext.publishEvent(new SendMessageEvent(this, message));
    }
}
