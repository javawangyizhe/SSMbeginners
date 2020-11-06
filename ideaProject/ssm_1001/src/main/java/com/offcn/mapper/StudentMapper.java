package com.offcn.mapper;

import com.offcn.pojo.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * ID查询信息
     */
    Student findStudentById(Integer id);
    /**
     * 查询全部Student信息
     */
    List<Student> findAllStudent();
    /**
     * 增加学生信息
     * @return
     */
    void insertStudent(Student student);
    /**
     * 删除学生信息
     * @return
     */
    void deleteStudent(Integer id);
    /**
     * 修改学生信息
     * @return
     */
    void updateStudent(Student student);
}
