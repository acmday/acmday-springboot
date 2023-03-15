package com.acmday.springboot.server.extension;

import com.acmday.springboot.server.service.IHelloService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author acmday
 * @date 2022/11/6 下午9:50
 */
@Slf4j
public class ApplicationListenerImpl implements ApplicationListener<ContextRefreshedEvent> {

    private static final Gson GSON = new Gson();
    Map<Integer, IHelloService> messageStrategyMap = new ConcurrentHashMap<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("act=[ApplicationListenerImpl#onApplicationEvent], parent={}, event={}",
                GSON.toJson(event.getApplicationContext().getParent()),
                GSON.toJson(event));
        ApplicationContext context = event.getApplicationContext();
        if(Objects.isNull(context.getParent())) {
            MapUtils.emptyIfNull(context.getBeansOfType(IHelloService.class))
                    .values()
                    .forEach(strategy -> {
                        messageStrategyMap.put(strategy.getType(), strategy);
                    });
        }
    }
}
