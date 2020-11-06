package com.offcn.test;

import com.offcn.mapper.RoleMapper;
import com.offcn.pojo.Role;
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

public class TestClass {
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
     * 通过id查询role和user
     */
    @Test
    public void Test(){
        sqlSession = factory.openSession(true);
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roles = mapper.findRoleAndUser(1);
        System.out.println(roles);

    }

    /**
     * 全部查询
     */
    @Test
    public void Test2(){
        sqlSession = factory.openSession(true);
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> all = mapper.findALL();
        System.out.println(all);
    }
}
