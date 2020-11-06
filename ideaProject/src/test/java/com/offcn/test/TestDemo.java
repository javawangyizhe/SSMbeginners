package com.offcn.test;

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

public class TestDemo {
    InputStream resourceAsStream;
    SqlSessionFactory factory;
    SqlSession sqlSession;
    /**
     * 读取配置文件获取工厂对象
     */
    @Before
    public void mybatis1(){
        try {
            //读取核心配置文件
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void close(){
        sqlSession.close();
    }

    /**
     * 增加
     */
    @Test
    public void insertUser(){
        sqlSession = factory.openSession(true);
        User user = new User();
        user.setUid(3);
        user.setUname("赵武");
        user.setUpwd("205123");
        int row = sqlSession.insert("insertUser",user);
        System.out.println(row);
    }
    /**
     * 删除
     */
    @Test
    public void deleteUser(){
        sqlSession = factory.openSession(true);
        int row = sqlSession.delete("deleteUserById",2);
        System.out.println(row);
    }
    /**
     * 修改
     */
    @Test
    public void updateUser(){
        sqlSession = factory.openSession(true);
        User user = new User();
        user.setUname("田七");
        user.setUpwd("654321");
        user.setUid(2);
        int row = sqlSession.update("updateUserById",user);
        System.out.println(row);
    }
    /**
     * 查询
     */
    @Test
    public void selectUser(){
        sqlSession = factory.openSession(true);
        List<User> list = sqlSession.selectList("findAllUsers");
        System.out.println(list);
    }
}
