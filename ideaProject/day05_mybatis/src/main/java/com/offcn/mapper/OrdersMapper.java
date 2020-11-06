package com.offcn.mapper;

import com.offcn.pojo.Orders;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersMapper {
    /**
     * 通过id找orders
     */
    @Select("select * from orders where cus_fk =#{id}")
    @Results(id = "findOrdersById",value = {
            @Result(id = true,column = "oid",property = "oid"),
            @Result(column = "odis",property = "odis"),
            @Result(column = "onum",property = "onum")
    })
    List<Orders> findOrdersById(Integer id);
}
