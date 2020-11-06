package com.offcn.mapper;

import com.offcn.pojo.Users;

import java.util.List;

public interface User_RoleMapper {
    /**
     * 根据id查找user
     */
    List<Users> findUserById(Integer id);
    /**
     * 查找所有user
     */
    List<Users> findAllUser();
}
