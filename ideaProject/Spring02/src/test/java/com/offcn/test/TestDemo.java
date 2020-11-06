package com.offcn.test;

import com.offcn.config.SpringContextAppConfig;
import com.offcn.service.CardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextAppConfig.class)
public class TestDemo {
    /**
     * 测试card实体类注解模式：component
     */
    @Test
    public void Test1(){
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Object card = context.getBean("card");
        //System.out.println(card);
    }
    /**
     * 测试cardService注解注入： @Autowired,
     *                        @Qualifier
     *                        @value
     * 完全注解
     */
    @Autowired
    private CardService cardService;
    @Test
    public void Test2(){
        System.out.println(cardService);
    }


}
