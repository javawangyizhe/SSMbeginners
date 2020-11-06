package com.offcn.mapper;

import com.offcn.pojo.Customer;
import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    Customer selectByPrimaryKey(Integer id);

    List<Customer> selectAll();

    int updateByPrimaryKey(Customer record);
}