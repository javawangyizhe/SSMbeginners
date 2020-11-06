package com.offcn.mapper;

import com.offcn.pojo.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface PersonMapper {
    /**
     * 根据id查询person和card：分步
     * @param id
     * @return
     */
    @Select("select * from person where id=#{id}")
    @Results(id="findPersonAndCard",value={
            @Result(id = true,column ="id",property = "id"),
            @Result(id = false,column ="name",property = "name"),
            @Result(property = "card",
                    id = false,column = "id",one = @One(
                    select = "com.offcn.mapper.CardMapper.findCardById",
                    fetchType = FetchType.EAGER

            ))
    })
    Person findPersonAndCard(Integer id);

    /**
     * 根据id查询person和card：一步
     */
    @Select("SELECT p.id AS pid,\n" +
            "p.name AS pname,\n" +
            "c.id AS cid,\n" +
            "c.name AS cname,\n" +
            "c.num AS cnum \n" +
            "FROM person p \n" +
            "LEFT JOIN card c \n" +
            "ON p.id=c.per_fk \n" +
            "WHERE p.id = #{id}")
    @Results(id = "findPerson",value ={
        @Result(id = true,column = "pid",property = "id"),
        @Result(column = "pname",property = "name"),
        @Result(column = "cid",property = "card.id"),
        @Result(column = "cname",property = "card.name"),
        @Result(column = "cnum",property = "card.num"),

    })
    Person findPerson(Integer id);
}
