package com.acmday.springboot.server.extension.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author acmday
 * @date 2022/11/6 下午11:52
 */
@Getter
@Setter
public class BaseEvent<T> extends ApplicationEvent {

    /**
     * 子类决定类型
     */
    public T payLoad;

    public BaseEvent(Object source, T payLoad) {
        super(source);
        this.payLoad = payLoad;
    }

    @JsonIgnore
    @Override
    public Object getSource() {
        return super.getSource();
    }
}
