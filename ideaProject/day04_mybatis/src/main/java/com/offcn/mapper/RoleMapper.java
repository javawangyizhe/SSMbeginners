package com.offcn.mapper;

import com.offcn.pojo.Role;

import java.util.List;

public interface RoleMapper {
    /**
     * 通过id查询role和users
     */
    List<Role> findRoleAndUser(Integer id);
    /**
     * 全部查询
     */
    List<Role> findALL();
}
