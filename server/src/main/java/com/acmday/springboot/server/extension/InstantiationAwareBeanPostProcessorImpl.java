package com.acmday.springboot.server.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

/**
 * @author acmday
 * @date 2022/9/27 下午11:15
 *
 * 该接口继承了BeanPostProcess接口，区别如下：BeanPostProcess接口只在bean的初始化阶段进行
 * 扩展（注入spring上下文前后），而InstantiationAwareBeanPostProcessor接口在此基础上增加
 * 了3个方法，把可扩展的范围增加了实例化阶段和属性注入阶段。该类主要的扩展点有以下5个方法，主要在bean生命周期的两大阶段：实例化阶段 和初始化阶段
 * postProcessBeforeInstantiation：实例化bean之前，相当于new这个bean之前
 * postProcessAfterInstantiation：实例化bean之后，相当于new这个bean之后
 * postProcessPropertyValues：bean已经实例化完成，在属性注入时阶段触发，@Autowired,@Resource等注解原理基于此方法实现
 * postProcessBeforeInitialization：初始化bean之前，相当于把bean注入spring上下文之前
 * postProcessAfterInitialization：初始化bean之后，相当于把bean注入spring上下文之后
 */
@Slf4j
public class InstantiationAwareBeanPostProcessorImpl implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("act=[InstantiationAwareBeanPostProcessor.postProcessBeforeInitialization] before initialization " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("act=[InstantiationAwareBeanPostProcessor.postProcessAfterInitialization] after initialization " + beanName);
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log.info("act=[InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation] before instantiation " + beanName);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        log.info("act=[InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation] after instantiation " + beanName);
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs,
            PropertyDescriptor[] pds,
            Object bean, String beanName) throws BeansException {
        log.info("act=[InstantiationAwareBeanPostProcessor.postProcessPropertyValues] postProcessPropertyValues " + beanName);
        return pvs;
    }
}
