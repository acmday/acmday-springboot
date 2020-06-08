package com.acmday.springboot.server.controller;

import com.acmday.springboot.dao.dao.model.Student;
import com.acmday.springboot.dao.service.DaoStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author acmday.
 * @date 2020/6/3.
 */
@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private DaoStudentService daoStudentService;

    @RequestMapping("/name")
    public String getAddressByName(String name) {
        log.info("act=getAddressByName name = {}", name);
        List<Student> list = daoStudentService.getStudentByName(name);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0).getAddress();
    }

    @RequestMapping("/id")
    public String getAddressById(int id) {
        log.info("act=getAddressById id = {}", id);
        return daoStudentService.getAddressById(id);
    }
}
