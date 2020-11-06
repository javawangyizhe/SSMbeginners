package com.offcn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.mapper.DeptMapper;
import com.offcn.mapper.EmpRoleMapper;
import com.offcn.mapper.EmployeeMapper;
import com.offcn.pojo.Dept;
import com.offcn.pojo.DialogResult;
import com.offcn.pojo.Employee;
import com.offcn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpRoleMapper empRoleMapper;
    @Override
    public PageInfo findAllEmps(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Employee> list = employeeMapper.findAllEmps();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
    /**
     * 模糊查询
     */
    @Override
    public PageInfo findAllEmpsWithCondition(String condition, Integer type, Integer pageNum, Integer pageSize) {
        if(type == 2 ){
            List<Dept> depts = deptMapper.findAlldepts();
            for (Dept dept : depts) {
                if(dept.getDname().equals(condition)){
                    PageHelper.startPage(pageNum,pageSize);
                    List<Employee> list = employeeMapper.findAllEmpsWithCondition(dept.getDeptno(),type);
                    PageInfo pageInfo = new PageInfo(list);
                    return pageInfo;
                }
            }
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Employee> list = employeeMapper.findAllEmpsWithCondition(condition,type);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
    /**
     * 增加员工信息
     */
    @Override
    public DialogResult insertEmp(Employee employee, Integer roleid) {
        DialogResult result = new DialogResult();

        try {
            //增加员工信息
            employeeMapper.insertEmp(employee);
            //增加新员工角色信息
            empRoleMapper.insertEmpRole(employee.getEid(),roleid);
            result.setMsg("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setError("添加失败");
        }
        return result;
    }
    /**
     * 根据id查询员工
     */
    @Override
    public Employee findEmpByEid(Integer eid) {
        Employee employee = employeeMapper.findEmpByEid(eid);
        return employee;
    }
    /**
     * 修改员工信息
     */
    @Override
    public DialogResult updateEmp(Employee employee, Integer roleid) {
        DialogResult result = new DialogResult();

        try {
            //修改员工信息
            employeeMapper.updateEmp(employee);
            //删除旧员工角色信息
            empRoleMapper.deleteRoleByEid(employee.getEid());
            //增加新员工角色信息
            empRoleMapper.insertEmpRole(employee.getEid(),roleid);
            result.setMsg("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setError("修改失败");
        }
        return result;
    }
    /**
     * 删除员工信息
     */
    @Override
    public DialogResult deleteEmpByEid(Integer eid) {
        DialogResult result = new DialogResult();
        try {
           //删除员工角色表信息
            empRoleMapper.deleteRoleByEid(eid);
            //删除员工信息
            employeeMapper.deleteEmpByEId(eid);
            result.setMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setError("删除失败");
        }
        return result;
    }
    /**
     * 删除多个员工信息
     */
    @Override
    public DialogResult deleteMutiEmps(String emps) {
        DialogResult result = new DialogResult();
        try {
            //截取字符串
            String[] emp = emps.split(",");
            for (String s : emp) {
                int eid = Integer.parseInt(s);
                //删除员工角色表信息
                empRoleMapper.deleteRoleByEid(eid);
                //删除员工信息
                employeeMapper.deleteEmpByEId(eid);
                result.setMsg("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setError("删除失败");
        }
        return result;
    }
}
