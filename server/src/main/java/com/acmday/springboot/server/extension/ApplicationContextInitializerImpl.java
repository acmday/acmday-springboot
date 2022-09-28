package com.acmday.springboot.server.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author acmday
 * @date 2022/9/26 下午11:52
 */
@Slf4j
public class ApplicationContextInitializerImpl implements ApplicationContextInitializer<ConfigurableApplicationContext>  {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        log.info("act=[ApplicationContextInitializer.initialize]");
    }
}
