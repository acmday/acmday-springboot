package com.acmday.springboot.server.service.role;

import com.acmday.springboot.server.annotation.Processor;
import com.acmday.springboot.server.service.IRoleService;

/**
 * @Author wushaofeng
 * @Date 2023/4/13 1:48 下午
 */
@Processor(groupName = "acmday", order = 2)
public class StudentRoleServiceImpl implements IRoleService {

    @Override
    public String getRole() {
        return "student";
    }
}
