package com.offcn.service;

import com.github.pagehelper.PageInfo;
import com.offcn.pojo.DialogResult;
import com.offcn.pojo.Role;

import java.util.List;

public interface RoleService {

    DialogResult insertRole(Role role, String sourcesNode);

    PageInfo findAllRolesWithPage(Integer pageNum,Integer pageSize);

    Role findRoleById(Integer id);

    void updateRole(String sid,Role role);

    DialogResult deleteRoleById(Integer id);

    DialogResult deleteMutiRoles(String roles);

    List<Role> findAllRoles();
}
