package com.offcn.mapper;

import com.offcn.pojo.Customer;

public interface CustomerMapper {
    /**
     * 通过name查找customer和其orders
     */
    Customer findCustomerByName(String name);
    /**
     * 分步查询
     */
    Customer findCustomer(String name);
}
