package com.acmday.springboot.server.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;

/**
 * @author acmday
 * @date 2022/9/28 上午9:07
 */
@Slf4j
public class BeanNameAwareImpl implements BeanNameAware {

    public BeanNameAwareImpl() {
        log.info("act=[BeanNameAware.construct]");
    }

    @Override
    public void setBeanName(String name) {
        log.info("act=[BeanNameAware.setBeanName] " + name);
    }

    @PostConstruct
    public void init() {
        log.info("act=[PostConstruct.init]");
    }
}
