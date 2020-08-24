package com.acmday.springboot.server.unit;

import com.acmday.springboot.dao.service.DaoStudentService;
import com.acmday.springboot.server.BaseClass;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author acmday.
 * @date 2020/8/24.
 */
@Slf4j
public class DaoTest extends BaseClass {

    @Resource
    private DaoStudentService studentService;

    @Test
    public void getData(){
        String result = studentService.getAddressById(1);
        log.info("act=getData result={}", result);
    }
}
