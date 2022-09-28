package com.acmday.springboot.server.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author acmday
 * @date 2022/9/27 下午11:26
 *
 */
@Slf4j
public class BeanFactoryAwareImpl implements BeanFactoryAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("act=[BeanFactoryAwareImpl.setBeanFactory] beanName={}",
                beanFactory.getBean(BeanFactoryAwareImpl.class).getClass().getSimpleName());
    }
}
