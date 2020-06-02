package com.acmday.springboot.server.component;

import com.acmday.springboot.server.bo.User;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author acmday.
 * @date 2020/4/18.
 * 使用ConversionServiceFactoryBean自定义类型转换器
 */
@Component
@Slf4j
@EqualsAndHashCode
public class UserConverter implements Converter<String, User> {

    @Override
    public User convert(String src) {

        log.info("act=UserConverter.convert time={}", src);
        User user = new User();

        if (src != null) {
            user.setName("name=" + src);
            user.setBirthday("acmday's birthday!");
        }
        return user;
    }
}
