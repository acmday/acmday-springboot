package com.acmday.springboot.server.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author acmday.
 * @date 2020/4/17.
 */
@Data
public class User {
    private String name;
    private String birthday;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
