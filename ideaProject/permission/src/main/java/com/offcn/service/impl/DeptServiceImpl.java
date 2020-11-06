package com.offcn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.mapper.DeptMapper;
import com.offcn.mapper.EmployeeMapper;
import com.offcn.pojo.Dept;
import com.offcn.pojo.DialogResult;
import com.offcn.pojo.Employee;
import com.offcn.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    /**
     * 分页查询所有dept
     */
    @Override
    public PageInfo findAlldeptsWithPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Dept> list = deptMapper.findAlldepts();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
    /**
     * 增加dept
     */
    @Override
    public void insertDept(Dept dept) {
        deptMapper.insertDept(dept);
    }
    /**
     * 根据id查dept
     */
    @Override
    public Dept findDeptById(Integer id) {
        Dept dept = deptMapper.findDeptById(id);
        return dept;
    }
    /**
     * 修改dept
     */
    @Override
    public void updateDept(Dept dept) {
        deptMapper.updateDept(dept);
    }
    /**
     * 根据删除dept
     */
    @Override
    public DialogResult deleteDeptById(Integer id) {
        DialogResult result = new DialogResult();
        try {
            //如果员工表中有部门id，不能删除
            List<Employee> list = employeeMapper.findEmpByDid(id);
            if(list.size() > 0){
                result.setError("部门中仍有员工，无法删除");
                return result;
            }
            //删除部门表中的数据
            deptMapper.deleteDeptById(id);
            result.setMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setError("删除失败");
        }
        return result;
    }
    /**
     * 多个删除
     */
    @Override
    public DialogResult deleteDeptByMutiId(String deptnos) {
        DialogResult result = new DialogResult();
        try {
            //截取字符串
            String[] deptno = deptnos.split(",");
            for (String s : deptno) {
                int did = Integer.parseInt(s);
                //如果员工表中有部门id，不能删除
                List<Employee> list = employeeMapper.findEmpByDid(did);
                if(list.size() > 0){
                    result.setError("部门中仍有员工，无法删除");
                    return result;
                }
                //删除部门表中的数据
                deptMapper.deleteDeptById(did);
            }
            result.setMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setError("删除失败");
        }
        return result;
    }
    /**
     * 查询所有dept
     */
    @Override
    public List<Dept> findAlldepts() {
        List<Dept> list = deptMapper.findAlldepts();
        return list;
    }
}
