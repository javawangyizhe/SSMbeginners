package com.text.spring;

import com.offcn.pojo.Card;
import com.offcn.service.CardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestSpring {
    @Autowired
    private CardService cardService;
    @Test
    public void Test(){
        Card card = cardService.findCardByIdService(1);
        System.out.println(card);
    }
}
