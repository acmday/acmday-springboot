package com.acmday.springboot.server.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author acmday
 * @date 2022/9/27 下午11:04
 */
@Slf4j
public class BeanDefinitionRegistryPostProcessorImpl implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        log.info("act=[BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry]");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        log.info("act=[BeanDefinitionRegistryPostProcessor.postProcessBeanFactory]");
    }
}
