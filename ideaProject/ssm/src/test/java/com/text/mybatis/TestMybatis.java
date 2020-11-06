package com.text.mybatis;

import com.offcn.mapper.CardMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.offcn.pojo.Card;
import java.io.InputStream;

public class TestMybatis{
    @Test
    public void Test() throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis/sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession(true);
        CardMapper cardMapper = session.getMapper(CardMapper.class);
        Card card = cardMapper.findCardById(1);
        System.out.println(card);
        session.close();
    }
}
