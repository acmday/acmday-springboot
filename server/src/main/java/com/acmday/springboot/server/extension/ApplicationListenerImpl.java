package com.acmday.springboot.server.extension;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author acmday
 * @date 2022/11/6 下午9:50
 */
@Slf4j
public class ApplicationListenerImpl implements ApplicationListener<ContextRefreshedEvent> {

    private static final Gson GSON = new Gson();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("act=[ApplicationListenerImpl#onApplicationEvent], parent={}, event={}",
                GSON.toJson(event.getApplicationContext().getParent()),
                GSON.toJson(event));
    }
}
