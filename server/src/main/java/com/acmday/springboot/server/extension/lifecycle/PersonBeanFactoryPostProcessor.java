package com.acmday.springboot.server.extension.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author acmday
 * @date 2023/2/26 上午12:11
 */
@Slf4j
@Component
public class PersonBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public PersonBeanFactoryPostProcessor() {
        super();
        log.info("【BeanFactoryPostProcessor】实现类构造器！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
            throws BeansException {
        log.info("【PersonBeanFactoryPostProcessor】调用postProcessBeanFactory方法");
        BeanDefinition bd = arg0.getBeanDefinition("person");
        bd.getPropertyValues().addPropertyValue("phone", "110");
    }

}
