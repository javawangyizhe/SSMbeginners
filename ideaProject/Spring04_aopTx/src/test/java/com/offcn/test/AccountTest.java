package com.offcn.test;

import com.offcn.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountTest {
    @Autowired
    private AccountService service;
    /**
     * 测试转账功能
     */
    @Test
    public void accountTest(){
        service.transfer(1001,1003,5d);
    }
}
