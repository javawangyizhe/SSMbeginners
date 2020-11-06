package com.offcn.service.impl;

import com.offcn.mapper.CardMapper;
import com.offcn.pojo.Card;
import com.offcn.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;
    @Override
    public Card findCardByIdService(Integer id) {
        return cardMapper.findCardById(id);
    }
}
