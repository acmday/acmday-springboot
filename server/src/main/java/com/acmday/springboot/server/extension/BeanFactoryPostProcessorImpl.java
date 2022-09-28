package com.acmday.springboot.server.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author acmday
 * @date 2022/9/27 下午11:13
 *
 * beanFactory的扩展接口，调用时机在spring在读取beanDefinition信息之后，实例化bean之前
 */
@Slf4j
public class BeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        log.info("act=[BeanFactoryPostProcessor.postProcessBeanFactory]");
    }
}
