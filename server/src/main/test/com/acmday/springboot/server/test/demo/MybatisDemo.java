package com.acmday.springboot.server.test.demo;

import com.acmday.springboot.server.Main;
import com.acmday.springboot.server.test.interfaces.UserMapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author acmday.
 * @date 2020/6/6.
 */
public class MybatisDemo {

    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class<?>[]{UserMapper.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return null;
                    }
                });
    }
}
