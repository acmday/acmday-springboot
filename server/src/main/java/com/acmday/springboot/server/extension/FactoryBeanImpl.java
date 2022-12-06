package com.acmday.springboot.server.extension;

import com.acmday.springboot.server.service.IHelloService;
import com.acmday.springboot.server.service.impl.HelloServiceImpl;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author acmday
 * @date 2022/11/5 上午12:04
 *
 * FactoryBeanImpl是一个FactoryBean
 */
public class FactoryBeanImpl implements FactoryBean<HelloServiceImpl> {

    @Override
    public HelloServiceImpl getObject() throws Exception {
        return new HelloServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return IHelloService.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
