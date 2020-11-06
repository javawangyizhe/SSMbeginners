package com.offcn.mapper;


import com.offcn.pojo.RoleSources;

import java.util.List;

public interface RoleSourcesMapper {


    List<RoleSources> findSourcesById(Integer id);

    void insertRoleSources(RoleSources roleSources);

    List<RoleSources> findSourcesByRid(Integer id);

    void deleteSourcesByRid(Integer roleid);
}