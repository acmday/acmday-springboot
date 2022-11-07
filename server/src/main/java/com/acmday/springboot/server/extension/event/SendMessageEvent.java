package com.acmday.springboot.server.extension.event;

import com.acmday.springboot.server.extension.entity.MessageEntity;

/**
 * @author acmday
 * @date 2022/11/6 下午11:55
 */
public class SendMessageEvent extends BaseEvent<MessageEntity> {

    public SendMessageEvent(Object source, MessageEntity payLoad) {
        super(source, payLoad);
    }
}