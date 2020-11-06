package com.offcn.mapper;


import com.offcn.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> findEmpByDid(Integer id);

    List<Employee> findAllEmps();

    List<Employee> findAllEmpsWithCondition(@Param("condition") String condition,@Param("type") Integer type);

    List<Employee> findAllEmpsWithCondition(@Param("condition") Integer condition,@Param("type") Integer type);

    void insertEmp(Employee employee);

    Employee findEmpByEid(Integer eid);

    void updateEmp(Employee employee);

    void deleteEmpByEId(Integer eid);
}