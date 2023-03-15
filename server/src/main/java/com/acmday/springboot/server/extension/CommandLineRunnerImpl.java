package com.acmday.springboot.server.extension;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author acmday
 * @date 2022/11/6 下午9:46
 */
@Slf4j
public class CommandLineRunnerImpl implements CommandLineRunner {
    /**
     * 触发时机为整个项目启动完毕后，自动执行。如果有多个CommandLineRunner，可以利用@Order来进行排序
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("act=[CommandLineRunner.run], args={}", Arrays.toString(args));
    }
}
