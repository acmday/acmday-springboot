package com.acmday.springboot.server.extension.entity;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author acmday
 * @date 2023/3/15 下午11:56
 */
@Component
@AllArgsConstructor
@ToString
@Builder
@Data
public class Teacher {

    private Long id;

    private String name;

    private String address;

    public Teacher() {
        id = 10010L;
        name = "ocean";
        address = "Beijing";
    }
}
