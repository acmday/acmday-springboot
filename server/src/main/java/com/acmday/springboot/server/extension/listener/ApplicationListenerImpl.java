package com.acmday.springboot.server.extension.listener;

import com.acmday.springboot.server.service.IHelloService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * @author acmday
 * @date 2022/11/6 下午9:50
 *
 * 1、ContextRefreshedEvent 事件会在Spring容器初始化完成会触发该事件。我们在实际工作也可以监听该事件去做一些事情。
 * 2、对于web应用会出现父子容器，会出发两次事件，需要注意影响。
 */
@Slf4j
@Service
public class ApplicationListenerImpl implements ApplicationListener<ContextRefreshedEvent> {

    private static final Gson GSON = new Gson();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("act=[ApplicationListenerImpl#onApplicationEvent], parent={}, event={}",
                GSON.toJson(event.getApplicationContext().getParent()),
                GSON.toJson(event));
        ApplicationContext context = event.getApplicationContext();
        if(Objects.isNull(context.getParent())) {
            Map<String, IHelloService> typeMap = context.getBeansOfType(IHelloService.class);
            typeMap.forEach((key, value) -> log.info("act=onApplicationEvent key={}, value={}", key,value));
        }
        Object source = event.getSource();
        log.info("act=onApplicationEvent source={}", source.getClass().getSimpleName());
    }
}
