package com.offcn.service.impl;

import com.offcn.dao.CardDao;
import com.offcn.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
      @Autowired
      private CardDao cardDao;


    @Override
    public String toString() {
        return "CardServiceImpl{" +
                "cardDao=" + cardDao +
                '}';
    }
}
