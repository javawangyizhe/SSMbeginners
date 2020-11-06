package com.offcn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.pojo.Student;
import com.offcn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 根据id查询学生信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("findStudentById")
    public String findStudentById(Integer id, Model model){
        Student student = studentService.findStudentById(id);
        model.addAttribute("student",student);
        return "index";
    }

    /**
     * 查询全部学生信息
     *
     * @return
     */
    @RequestMapping("findAllStudent")
    public String findAllStudent(@RequestParam(required = true, defaultValue = "1") Integer page,Model model){
        PageHelper.startPage(page,10);
        List<Student> list = studentService.findAllStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        model.addAttribute("list",list);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }
    /**
     * 增加学生信息
     */
    @RequestMapping(value = "insertStudent",method = RequestMethod.POST)
    @ResponseBody
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }
    /**
     * 删除学生信息
     */
    @RequestMapping("deleteStudent")
    @ResponseBody
    public void deleteStudent(Integer id){
        studentService.deleteStudent(id);
    }
    /**
     * 修改学生信息
     */
    @RequestMapping(value = "updateStudent",method = RequestMethod.POST)
    @ResponseBody
    public void updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
    }
}
