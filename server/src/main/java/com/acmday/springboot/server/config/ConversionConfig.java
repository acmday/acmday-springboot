package com.acmday.springboot.server.config;

import com.acmday.springboot.server.component.UserConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author acmday.
 * @date 2020/4/17.
 */
@Configuration
public class ConversionConfig {
    @Bean
    public ConversionService getConversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();
        converters.add(new UserConverter());
        return converters;
    }
}
