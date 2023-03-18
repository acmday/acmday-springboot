package com.acmday.springboot.server.extension.tmp;

import com.acmday.springboot.server.extension.listener.EventPublishServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @author acmday
 * @date 2023/3/16 上午12:09
 */
@Slf4j
public class PublishListenTest  {

    @Resource
    private EventPublishServiceImpl publishListenService;
//
//    @Test
//    public void postConstructExtend() {
//        log.info("test=postConstructExtend");
//    }
//
//    @Test
//    public void applicationContextPublish() {
//        publishListenService.applicationContextPublish();
//    }
//
//    @Test
//    public void publishEvent() {
//        publishListenService.publishEvent();
//    }
}
