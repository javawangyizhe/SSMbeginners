package com.offcn.controller;

import com.github.pagehelper.PageInfo;
import com.offcn.pojo.*;
import com.offcn.service.DeptService;
import com.offcn.service.EmployeeRoleService;
import com.offcn.service.EmployeeService;
import com.offcn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private EmployeeRoleService employeeRoleService;

    /**
     * 分页查询全部
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping("findAllEmps")
    public String findAllEmps(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                              @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                              Model model){
        PageInfo pageInfo = employeeService.findAllEmps(pageNum,pageSize);
        List<Dept> depts = deptService.findAlldepts();
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("depts",depts);
        return "forward:list-employee.jsp";
    }

    /**
     * 模糊查询
     * @param pageNum
     * @param pageSize
     * @param condition
     * @param type
     * @param model
     * @return
     */
    @RequestMapping("serachAllEmpWithCondition")
    public String serachAllEmpWithCondition(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize,
                                              String condition,
                                              Integer type,
                                              Model model){
        PageInfo pageInfo = employeeService.findAllEmpsWithCondition(condition,type,pageNum,pageSize);
        List<Dept> depts = deptService.findAlldepts();
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("depts",depts);
        return "forward:list-employee.jsp";
    }

    /**
     * 修改信息回显查询
     * @param eid
     * @return
     */
    @RequestMapping("loadEmpsAndDeptsAndRoles")
    public String loadEmpsAndDeptsAndRoles(Integer eid,Model model){
        //查询员工基本信息
        Employee employee = employeeService.findEmpByEid(eid);
        //查询部门信息
        List<Dept> depts = deptService.findAlldepts();
        //查询角色信息
        List<Role> roles = roleService.findAllRoles();
        //查询员工角色信息
        EmpRole empRole = employeeRoleService.findEmpRoleByEid(eid);
        model.addAttribute("emp",employee);
        model.addAttribute("depts",depts);
        model.addAttribute("roles",roles);
        model.addAttribute("empRole",empRole);
        return "forward:show-employee.jsp";
    }
    /**
     * 增加信息dept和role回显
     */
    @RequestMapping("loadDeptsAndRoles")
    public String loadDeptsAndRoles(Model model){
        //查询部门
        List<Dept> depts = deptService.findAlldepts();
        //查询角色
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("depts",depts);
        model.addAttribute("roles",roles);
        return "forward:save-employee.jsp";
    }
    /**
     * 增加员工信息
     */
    @RequestMapping("insertEmp")
    @ResponseBody
    public DialogResult insertEmp(Employee employee, Integer roleid){
        DialogResult dialogResult = employeeService.insertEmp(employee,roleid);
        return dialogResult;
    }
    /**
     * 修改员工信息
     */
    @RequestMapping("updateEmp")
    @ResponseBody
    public DialogResult updateEmp(Employee employee, Integer roleid){
        DialogResult dialogResult = employeeService.updateEmp(employee,roleid);
        return dialogResult;
    }
    /**
     * 删除员工信息
     */
    @RequestMapping("deleteEmpByEid")
    @ResponseBody
    public DialogResult deleteEmpByEid(Integer eid){
        DialogResult dialogResult = employeeService.deleteEmpByEid(eid);
        return dialogResult;
    }
    /**
     * 删除多个员工信息
     */
    @RequestMapping("deleteMutiEmps")
    @ResponseBody
    public DialogResult deleteMutiEmps(String emps){
        DialogResult dialogResult = employeeService.deleteMutiEmps(emps);
        return dialogResult;
    }



}
