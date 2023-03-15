package com.acmday.springboot.server.extension.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author acmday
 * @date 2023/2/26 上午12:06
 */
@Slf4j
@Component
public class PersonBeanPostProcessor implements BeanPostProcessor {

    public PersonBeanPostProcessor() {
        super();
        log.info("【BeanPostProcessor】实现类构造器！！");
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1)
            throws BeansException {
        log.info("【BeanPostProcessor】接口方法postProcessAfterInitialization对属性进行更改！");
        return arg0;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)
            throws BeansException {
        log.info("【BeanPostProcessor】接口方法postProcessBeforeInitialization对属性进行更改！");
        return arg0;
    }
}
