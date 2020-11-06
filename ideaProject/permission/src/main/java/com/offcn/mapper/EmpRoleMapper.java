package com.offcn.mapper;


import com.offcn.pojo.EmpRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpRoleMapper {

    List<EmpRole> findRoleByRid(Integer id);

    void deleteRoleByEid(Integer eid);

    void insertEmpRole(@Param("eid") Integer eid,@Param("roleid") Integer roleid);

    EmpRole findEmpRoleByEid(Integer eid);
}