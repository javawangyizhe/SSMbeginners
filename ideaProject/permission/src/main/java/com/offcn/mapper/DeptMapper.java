package com.offcn.mapper;


import com.offcn.pojo.Dept;

import java.util.List;

public interface DeptMapper {

    List<Dept> findAlldepts();

    void insertDept(Dept dept);

    Dept findDeptById(Integer id);

    void updateDept(Dept dept);

    void deleteDeptById(Integer id);
}