package com.offcn.service;

import com.github.pagehelper.PageInfo;
import com.offcn.pojo.DialogResult;
import com.offcn.pojo.Employee;

public interface EmployeeService {
    PageInfo findAllEmps(Integer pageNum, Integer pageSize);

    PageInfo findAllEmpsWithCondition(String condition, Integer type, Integer pageNum, Integer pageSize);

    DialogResult insertEmp(Employee employee, Integer roleid);

    Employee findEmpByEid(Integer eid);

    DialogResult updateEmp(Employee employee, Integer roleid);

    DialogResult deleteEmpByEid(Integer eid);

    DialogResult deleteMutiEmps(String emps);
}
