package com.offcn.mapper;

import com.offcn.pojo.Card;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface CardMapper {
    /**
     * 根据id查询card
     */
    @Select("select * from card where per_fk=#{id}")
    @Results(id = "findCardById",value={
            @Result(id = true,column = "id",property = "id"),
            @Result(id = false,column = "name",property = "name"),
            @Result(id = false,column = "num",property = "num"),
    })
    Card findCardById(Integer id);
}
