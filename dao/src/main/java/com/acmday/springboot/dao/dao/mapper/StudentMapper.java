package com.acmday.springboot.dao.dao.mapper;

import com.acmday.springboot.dao.dao.model.Student;
import com.acmday.springboot.dao.dao.model.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    @Select(value = "select address from student where id=#{id}")
    String getAddressById(int id);
}