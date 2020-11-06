package com.offcn.test;

import com.offcn.mapper.CustomerMapper;
import com.offcn.pojo.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo {
    InputStream resourceAsStream;
    SqlSessionFactory factory;
    SqlSession sqlSession;

    @Before
    public void before(){
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void Test(){
        sqlSession = factory.openSession(true);
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.selectAll();
        System.out.println(customers);
    }
}
