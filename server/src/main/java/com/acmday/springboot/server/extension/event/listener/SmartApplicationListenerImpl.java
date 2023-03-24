package com.acmday.springboot.server.extension.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 3:24 下午
 *
 * 1. Spring 提供了一个SmartApplicationListener类，可以支持listener之间的触发顺序，普通的ApplicationListener优先级最低（最后触发）。
 */
@Component
@Slf4j
public class SmartApplicationListenerImpl implements SmartApplicationListener {

    private volatile AtomicBoolean initStatus = new AtomicBoolean(false);

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == ContextRefreshedEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return SmartApplicationListener.super.supportsSourceType(sourceType);
    }

    @Override
    public int getOrder() {
        log.info("act=[SmartApplicationListenerImpl#getOrder] super.order={}",
            SmartApplicationListener.super.getOrder());
        return 1;
    }

    @Override
    public String getListenerId() {
        return SmartApplicationListener.super.getListenerId();
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("act=[SmartApplicationListenerImpl#onApplicationEvent] super.order={}",
            SmartApplicationListener.super.getOrder());
        if (!initStatus.compareAndSet(false, true)) {
            return;
        }
        log.info("-------------------init------------");
    }
}
