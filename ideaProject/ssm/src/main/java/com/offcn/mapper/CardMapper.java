package com.offcn.mapper;
import com.offcn.pojo.Card;
public interface CardMapper {
    /**
     * 根据id查询card
     */

    Card findCardById(Integer id);
}
