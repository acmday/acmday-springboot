package com.acmday.springboot.server.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @author acmday
 * @date 2022/11/6 下午9:48
 */
@Slf4j
public class DisposableBeanImpl implements DisposableBean {

    /**
     * 触发时机为当此对象销毁时，会自动执行这个方法。比如说运行applicationContext.registerShutdownHook时，就会触发这个方法
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        log.info("act=[DisposableBean.destroy]");
    }
}
