package com.acmday.springboot.server.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author acmday
 * @date 2022/9/28 上午9:12
 */
@Slf4j
public class InitializingBeanImpl implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("act=[InitializingBean.afterPropertiesSet]");
    }
}
