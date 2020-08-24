package com.acmday.springboot.dao.service;

import com.acmday.springboot.dao.mapper.StudentMapper;
import com.acmday.springboot.dao.model.Student;
import com.acmday.springboot.dao.model.StudentExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author acmday.
 * @date 2020/6/3.
 */
@Service
@Slf4j
public class DaoStudentService {

    @Resource
    private StudentMapper studentMapper;

    public List<Student> getStudentByName(String name) {
        StudentExample cond = new StudentExample();
        cond.createCriteria().andNameEqualTo(name);
        return studentMapper.selectByExample(cond);
    }

    public String getAddressById(int id) {
        return studentMapper.getAddressById(id);
    }
}
