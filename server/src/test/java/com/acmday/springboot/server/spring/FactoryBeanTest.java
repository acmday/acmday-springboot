package com.acmday.springboot.server.spring;

import com.acmday.springboot.server.BaseTest;
import com.acmday.springboot.server.extension.FactoryBeanImpl;
import com.acmday.springboot.server.extension.entity.Teacher;
import com.acmday.springboot.server.service.IHelloService;
import com.acmday.springboot.server.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author acmday
 * @date 2022/11/5 下午11:45
 */
@Slf4j
public class FactoryBeanTest extends BaseTest {

    @Test
    public void getBean1() {
        // 获取beanDefinition
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();

        // 创建工厂bean
        beanDefinition.setBeanClass(Teacher.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBeanDefinition("teacher", beanDefinition);
        context.refresh();
        Teacher person = context.getBean(Teacher.class);
        log.info("teacher={}", person);

        log.info("现在开始关闭容器！");
        context.registerShutdownHook();
    }

    @Test
    public void getBean2() throws Exception {
        // 获取beanDefinition
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();

        // 创建工厂bean
        beanDefinition.setBeanClass(FactoryBeanImpl.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBeanDefinition("factoryBeanImpl", beanDefinition);
        context.refresh();
        FactoryBeanImpl bean = context.getBean(FactoryBeanImpl.class);

        // 验证工厂bean创建的对象是否已经被IOC容器托管
        IHelloService helloService = bean.getObject();
        log.info("test={}", helloService.echo("getBean2"));

        // 获取工厂bean的信息(&其实就是取地址符)
        Object factoryBean = context.getBean("&factoryBeanImpl");
        log.info("test.factoryBeanName={}", factoryBean.getClass().getSimpleName());
    }

    @Test
    public void getBean3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloServiceImpl.class);
        IHelloService helloService = context.getBean(IHelloService.class);
        String echo = helloService.echo("getBean1");
        log.info("test={}", echo);
    }
}
