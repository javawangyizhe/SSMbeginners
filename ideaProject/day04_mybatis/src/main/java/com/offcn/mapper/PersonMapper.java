package com.offcn.mapper;

import com.offcn.pojo.Person;

public interface PersonMapper {
    /**
     * 通过id查询person信息和card信息
     */
    Person findPersonById(Integer id);
}
