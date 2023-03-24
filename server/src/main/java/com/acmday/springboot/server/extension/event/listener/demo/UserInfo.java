package com.acmday.springboot.server.extension.event.listener.demo;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 5:32 下午
 */

public class UserInfo {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo [name=" + name + ", age=" + age + "]";
    }

}