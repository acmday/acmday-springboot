package com.acmday.springboot.server.service;

import com.acmday.springboot.server.BaseTest;
import com.acmday.springboot.server.service.impl.PublishListenServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author acmday
 * @date 2022/11/4 上午9:58
 */
@Slf4j
public class ExtendServiceTest extends BaseTest {

    @Resource
    private IExtendService extendService;

    @Resource
    private PublishListenServiceImpl publishListenService;

    @Test
    public void postConstructExtend() {
        log.info("test=postConstructExtend");
    }

    @Test
    public void applicationContextPublish() {
        publishListenService.applicationContextPublish();
    }

    @Test
    public void publishEvent() {
        publishListenService.publishEvent();
    }
}
