package com.offcn;


import com.offcn.mapper.StudentMapper;
import com.offcn.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class mybatisTest {

    @Test
    public void Test() throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = factory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.findStudentById(1);
        System.out.println(student);
    }
}
