package com.acmday.springboot.server.extension;

import com.acmday.springboot.server.annotation.AnnoAttributeExtend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author acmday
 * @date 2022/11/6 上午11:07
 */
@Slf4j
@Component
public class SmartInitializingSingletonImpl implements SmartInitializingSingleton {

    private ListableBeanFactory beanFactory;

    public SmartInitializingSingletonImpl(ListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     *  1.在spring容器管理的所有单例对象（非懒加载对象）初始化完成之后调用的回调接口。
     *  2.触发时机为postProcessAfterInitialization之后。
     *  3.在DefaultListableBeanFactory#preInstantiateSingletons()方法中最后执行。
     *  4.实现类例如：EventListenerMethodProcessor
     */
    @Override
    public void afterSingletonsInstantiated() {
        String[] beanNames = beanFactory.getBeanNamesForAnnotation(AnnoAttributeExtend.class);
        log.info("act=[SmartInitializingSingleton.afterSingletonsInstantiated] beanNames={}",
                Arrays.toString(beanNames));
    }
}
