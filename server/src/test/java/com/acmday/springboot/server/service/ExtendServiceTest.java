package com.acmday.springboot.server.service;

import com.acmday.springboot.server.BaseTest;
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

    @Test
    public void postConstructExtend() {
        log.info("test=postConstructExtend");
    }
}
