package com.offcn.service;

import com.github.pagehelper.PageInfo;
import com.offcn.pojo.Dept;
import com.offcn.pojo.DialogResult;

import java.util.List;

public interface DeptService {
    PageInfo findAlldeptsWithPage(Integer pageNum, Integer pageSize);

    void insertDept(Dept dept);

    Dept findDeptById(Integer id);

    void updateDept(Dept dept);

    DialogResult deleteDeptById(Integer id);

    DialogResult deleteDeptByMutiId(String deptnos);

    List<Dept> findAlldepts();
}
