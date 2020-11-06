package com.offcn.dao;

import com.offcn.pojo.Card;

import java.util.List;

public interface CardDao {
    Card findCardById(Integer id);
    List<Card> findAllCard();

    void insert(Card card);

    void update(Card card);

    void deleteById(Integer id);
}
