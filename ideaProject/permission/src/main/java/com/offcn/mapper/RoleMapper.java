package com.offcn.mapper;


import com.offcn.pojo.Role;

import java.util.List;

public interface RoleMapper {

    void insertRole(Role role);

    List<Role> findAllRoles();

    Role findRoleById(Integer id);

    void updateRole(Role role);

    void deleteRoleById(Integer id);
}