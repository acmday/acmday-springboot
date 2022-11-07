package com.acmday.springboot.server.service.impl;

import com.acmday.springboot.server.extension.entity.MessageEntity;
import com.acmday.springboot.server.extension.event.SendMessageEvent;
import com.acmday.springboot.server.service.IPublishListenService;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author acmday
 * @date 2022/11/6 下午11:50
 */
@Service
public class PublishListenServiceImpl implements IPublishListenService {

    @Resource
    private ApplicationContext applicationContext;

    public void applicationContextPublish() {
        MessageEntity message = MessageEntity.builder()
                .messageId(1L)
                .content("applicationContextPublish.test")
                .tag("tag")
                .build();
        applicationContext.publishEvent(new SendMessageEvent(this, message));
    }
}
