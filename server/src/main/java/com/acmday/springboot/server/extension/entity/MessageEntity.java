package com.acmday.springboot.server.extension.entity;

import lombok.*;

/**
 * @author acmday
 * @date 2022/11/6 下午11:56
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString
public class MessageEntity {

    /**
     * 消息id
     */
    private Long messageId;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 标签
     */
    private boolean tag=false;
}
