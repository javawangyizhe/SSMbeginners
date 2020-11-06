package com.offcn.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.offcn.mapper.CustomerMapper;
import com.offcn.mapper.PersonMapper;
import com.offcn.mapper.UsersMapper;
import com.offcn.pojo.Customer;
import com.offcn.pojo.Person;
import com.offcn.pojo.Users;
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

public class TestUsers {
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
     * 通过id找person信息和card信息
     */
    @Test
    public void Test5(){
        sqlSession = factory.openSession(true);
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person person = mapper.findPersonById(1);
        System.out.println(person);
        sqlSession.commit();
        //验证二级缓存开启
        //sqlSession.close();
        //SqlSession sqlSession1 = factory.openSession(true);
        //PersonMapper mapper1 = sqlSession1.getMapper(PersonMapper.class);
        //Person person1 = mapper1.findPersonById(1);
        //System.out.println(person1);
        Person person1 = mapper.findPersonById(1);
        System.out.println(person1);
    }

    /**
     * 通过name查找customer和其orders
     */
    @Test
    public void Test6(){
        sqlSession = factory.openSession(true);
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.findCustomerByName("张三");
        System.out.println(customer);
    }

    /**
     * 分步查询
     */
    @Test
    public void Test7(){
        sqlSession = factory.openSession(true);
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.findCustomer("张三");
        System.out.println(customer);
    }
}
