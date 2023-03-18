package com.acmday.springboot.server.extension.a;

import org.springframework.context.ApplicationEvent;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 5:33 下午
 */
public class UserDelEvent extends ApplicationEvent {

    private static final long serialVersionUID = -3910960183687086015L;

    private UserInfo user;

    public UserDelEvent(Object source, UserInfo user) {
        super(source);
        this.user = user;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserDeleteEvent [user=" + user + "]";
    }
}
