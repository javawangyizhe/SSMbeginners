package com.offcn.controller;

import com.github.pagehelper.PageInfo;
import com.offcn.pojo.Dept;
import com.offcn.pojo.DialogResult;
import com.offcn.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping("findAlldepts")
    public String findAlldepts(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "3")Integer pageSize,
                               Model model){
        PageInfo pageInfo = deptService.findAlldeptsWithPage(pageNum,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        return "forward:list-dept.jsp";
    }
    @RequestMapping("saveDept")
    public String insertDept(Dept dept){
        deptService.insertDept(dept);
        return "forward:findAlldepts";
    }
    /**
     * 根据id查找dept
     */
    @RequestMapping("findDeptById")
    @ResponseBody
    public Dept findDeptById(Integer deptno){
        Dept dept = deptService.findDeptById(deptno);
        return dept;
    }
    /**
     * 修改dept
     */
    @RequestMapping("updateDept")
    public String updateDept(Dept dept){
        deptService.updateDept(dept);
        return "forward:findAlldepts";
    }

    /**
     * 根据id删除dept
     */
    @RequestMapping("deleteDeptById")
    @ResponseBody
    public DialogResult deleteDeptById(Integer id){
        DialogResult dialogResult = deptService.deleteDeptById(id);
        return dialogResult;
    }
    /**
     * 多项删除
     */
    @RequestMapping("deleteMutiDepts")
    @ResponseBody
    public DialogResult deleteMutiDepts(String deptnos){
        DialogResult result = deptService.deleteDeptByMutiId(deptnos);
        return result;
    }

}
