package com.acmday.springboot.server.test.demo;

import com.acmday.springboot.dao.dao.mapper.StudentMapper;
import com.acmday.springboot.dao.dao.model.Student;
import com.acmday.springboot.server.Main;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author acmday.
 * @date 2020/6/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@Slf4j
public class SqlSessionDemo {

    @Resource
    private DataSource dataSource;

    @Test
    public void test() {

        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("dev", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(StudentMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            String student = (String) session.selectOne("com.acmday.springboot.dao.dao.mapper.StudentMapper.getAddressById",1);
            log.info("---test={}", new Gson().toJson(student));
        }
    }
}
