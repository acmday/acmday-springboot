package com.acmday.springboot.server.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author acmday
 * @date 2022/11/4 上午9:49
 */
@Slf4j
@Component
public class PostConstructInit {

    public PostConstructInit() {
        log.info("act=[PostConstructInit] construct");
    }

    @PostConstruct
    public void init(){
        log.info("act=[PostConstructInit] init");
    }
}
