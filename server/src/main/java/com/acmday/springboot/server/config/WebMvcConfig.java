package com.acmday.springboot.server.config;

import com.acmday.springboot.server.component.ResultBeanConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author acmday.
 * @date 2020/4/19.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(resultBeanConverter());
        super.extendMessageConverters(converters);
    }

    @Bean
    public ResultBeanConverter resultBeanConverter(){
        return new ResultBeanConverter();
    }
}
