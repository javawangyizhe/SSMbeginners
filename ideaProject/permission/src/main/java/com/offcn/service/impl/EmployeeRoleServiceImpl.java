package com.offcn.service.impl;

import com.offcn.mapper.EmpRoleMapper;
import com.offcn.pojo.EmpRole;
import com.offcn.service.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    @Autowired
    private EmpRoleMapper empRoleMapper;
    /**
     * 根据eid查询员工信息
     */
    @Override
    public EmpRole findEmpRoleByEid(Integer eid) {
        EmpRole empRole = empRoleMapper.findEmpRoleByEid(eid);
        return empRole;
    }
}
