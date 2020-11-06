package com.offcn.mapper;

import com.offcn.pojo.Orders;

import java.util.List;

public interface OrdersMapper {
    /**
     * 根据id查询订单信息
     */
    List<Orders> findOrdersById(Integer id);
}
