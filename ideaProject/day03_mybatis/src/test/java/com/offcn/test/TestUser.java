package com.offcn.test;

import com.offcn.mapper.UserMapper;
import com.offcn.pojo.User;
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

public class TestUser {
    private InputStream resourceAsStream;
    private SqlSessionFactory factory;
    private SqlSession sqlsession;
    @Before
    public void before(){
        try {
            //读取配置文件信息
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            //获取工厂
            factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        sqlsession.close();
    }

    /**
     * 根据id获取user
     */
    @Test
    public void TestFindUserById(){
        sqlsession = factory.openSession(true);
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);
        System.out.println(user);
    }

    /**
     * 查找所有user
     */
    @Test
    public void TestfindAllUser(){
        sqlsession = factory.openSession(true);
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        List<User> list = mapper.findAllUser();
        System.out.println(list);
    }

    /**
     *模糊查询
     */
    @Test
    public void TestfindUserByName(){
        sqlsession = factory.openSession(true);
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        List<User> list = mapper.findUserByName("%白%");
        System.out.println(list);
    }

    /**
     * 查询总条数
     */
    @Test
    public void TestfindCount(){
        sqlsession = factory.openSession(true);
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        Integer count = mapper.findCount();
        System.out.println(count);
    }

    /**
     * 增加user
     */
    @Test
    public void TestinsertUser(){
        sqlsession = factory.openSession(true);
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = new User();
        user.setUpwd("475215");
        user.setUname("安暖");
        Integer row = mapper.insertUser(user);
        System.out.println(row);
    }

    /**
     * 修改user
     */
    @Test
    public void TestupdateUser(){
        sqlsession = factory.openSession(true);
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = new User();
        user.setUname("张凌云");
        user.setUpwd("234251");
        user.setUid(2);
        Integer integer = mapper.updateUser(user);
        System.out.println(integer);
    }

    /**
     * 删除user
     */
    @Test
    public void TestdeleteUser(){
        sqlsession = factory.openSession(true);
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        mapper.deleteUserById(5);
    }

}
