package com.acmday.springboot.server.component;

import com.acmday.springboot.server.bo.User;
import com.acmday.springboot.server.bo.constants.Constants;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author acmday.
 * @date 2020/4/19.
 */
@Slf4j
public class ResultBeanConverter extends AbstractHttpMessageConverter<User> {

    public ResultBeanConverter() {
        super(MediaType.valueOf(Constants.PROPERTIES_USER));
        //super(MediaType.APPLICATION_JSON);
        setDefaultCharset(StandardCharsets.UTF_8);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(User.class);
    }

    @Override
    protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream is = inputMessage.getBody();
        Properties props = new Properties();
        props.load(is);

        String birthday = props.getProperty("birthday");
        String name = props.getProperty("name");

        User user = new User();
        user.setBirthday("acmday’s birthday is:"+birthday);
        user.setName(name);
        log.info("act=readInternal birthday={}, name={}, props={}", birthday, name, new Gson().toJson(props));
        return user;
    }

    @Override
    protected void writeInternal(User user, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream os = outputMessage.getBody();
        Properties properties = new Properties();
        properties.setProperty("birthday", user.getBirthday());
        properties.setProperty("name", user.getName());
        properties.store(os, "acmday-user-comments");
        log.info("act=writeInternal user={}", new Gson().toJson(user));
        outputMessage.getBody().write(user.toString().getBytes());
    }
}
