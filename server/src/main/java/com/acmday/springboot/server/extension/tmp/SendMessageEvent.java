package com.acmday.springboot.server.extension.tmp;

import com.acmday.springboot.server.constant.Common;
import com.acmday.springboot.server.extension.entity.MessageEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * @author acmday
 * @date 2022/11/6 下午11:55
 */
@Slf4j
public class SendMessageEvent extends BaseEvent<MessageEntity> {

    public SendMessageEvent(Object source, MessageEntity payLoad) {
        super(source, payLoad);
        log.info("act=[SendMessageEvent] payLoad={}", Common.GSON.toJson(this.getPayLoad()));
    }
}
