package com.offcn.service.impl;

import com.offcn.mapper.StudentMapper;
import com.offcn.pojo.Student;
import com.offcn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据id查询学生信息
     * @param id
     * @return
     */
    @Override
    public Student findStudentById(Integer id) {
        Student student = studentMapper.findStudentById(id);
        return student;
    }

    /**
     * 分页查询全部学生信息
     * @return
     */
    @Override
    public List<Student> findAllStudent() {
        List<Student> list = studentMapper.findAllStudent();
        return list;
    }

    /**
     * 增加学生信息
     * @param student
     * @return
     */
    @Override
    public void insertStudent(Student student) {
        studentMapper.insertStudent(student);

    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    @Override
    public void deleteStudent(Integer id) {
        studentMapper.deleteStudent(id);

    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);

    }

}
