package com.offcn.test;

import com.offcn.pojo.Card;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class TestDemo {
    /*@Test*/
    /**
     * bean的初始化方式：无参构造器
     */
  /*  public void Test1(){
        //读取Spring核心配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object card = context.getBean("card");
        System.out.println(card);
    }*/
    /**
     * bean的初始化方式：静态工厂模式
     * bean的初始化方式:普通工厂模式
     */
    @Test
    public void Test2(){
        //读取Spring核心配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    }

    /**
     * init方法和destroy方法
     */
    @Test
    public void Test3(){
        //读取Spring核心配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.close();
    }
    /**
     * 依赖注入：DI
     * card4，card5，card6
     */
    @Test
    public void Test4(){
        //读取Spring核心配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object card4 = context.getBean("card6");
        System.out.println(card4);
    }
    /**
     * JDBCTemplate模板对象
     */
    @Test
    public void Test5(){
        //读取Spring核心配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource datasource =(DataSource) context.getBean("dataSource");
        JdbcTemplate template = new JdbcTemplate(datasource);

        //String sql = "insert into card(name,num) values (?,?)";
        //template.update(sql, "赵六", 4);

        //String sql = "update card set name = ?,num = ? where id = 4";
        //template.update(sql,"zhaoliu",1004);

        //String sql = "delete from card where id = ?";
        //template.update(sql,4);

        //String sql = "select * from card";
        //List<Card> query = template.query(sql, new BeanPropertyRowMapper<Card>(Card.class));
        //System.out.println(query);

        String sql = "select * from card where id = ?";
        Card card = template.queryForObject(sql, new BeanPropertyRowMapper<Card>(Card.class), 1);
        System.out.println(card);

        

    }

}
