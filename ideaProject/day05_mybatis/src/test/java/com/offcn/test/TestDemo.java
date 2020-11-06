package com.offcn.test;

import com.offcn.mapper.CustomerMapper;
import com.offcn.mapper.PersonMapper;
import com.offcn.pojo.Customer;
import com.offcn.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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

    /**
     * 根据id查询person和card
     */
    @Test
    public void Test1(){
        sqlSession = factory.openSession(true);
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.findPersonAndCard(1);
        System.out.println(person);
    }

    /**
     * 通过id查询customer和orders
     */
    @Test
    public void Test2(){
        sqlSession = factory.openSession(true);
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.findCustomerAndOrders(1);
        System.out.println(customer);
    }
    /**
     * 一步查
     */
    @Test
    public void Test3(){
        sqlSession = factory.openSession(true);
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.findPerson(1);
        System.out.println(person);
    }
}
