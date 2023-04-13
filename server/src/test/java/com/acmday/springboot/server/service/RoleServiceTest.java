package com.acmday.springboot.server.service;

import com.acmday.springboot.server.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wushaofeng
 * @Date 2023/4/13 1:52 下午
 */
@Slf4j
public class RoleServiceTest extends BaseTest {

    @Resource
    private List<IRoleService> roleServiceList;

    @Test
    public void printRole() {
        roleServiceList.forEach(item -> {
            log.info("role={}", item.getRole());
        });
    }
}
