package com.acmday.springboot.server.extension.listener;

import com.acmday.springboot.server.extension.listener.event.TeacherEvent;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author wushaofeng
 * @Date 2023/3/17 3:50 下午
 *
 * 1、监听器方法中一定要try-catch异常，否则会造成发布事件(有事务的)的方法进行回滚
 * 2、可以使用@Order注解来控制多个监听器的执行顺序，@Order传入的值越小，执行顺序越高
 * 3、对于需要进行事务监听或不想try-catch runtime异常，可以使用@TransactionalEventListener注解
 * https://blog.csdn.net/wanping321/article/details/86667216
 */
@Component
@Slf4j
public class TeacherEventListener {

    private static final Gson GSON = new Gson();

    @EventListener
    public void handleEvent(TeacherEvent event){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("act=[TeacherEventListener#handleEvent] event={}", GSON.toJson(event));
    }
}
