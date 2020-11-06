package com.offcn.mapper;

import com.offcn.pojo.Customer;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface CustomerMapper {
    /**
     * 通过id查询customer和orders
     */
    @Select("select * from customer where id=#{id}")
    @Results(id="findCustomerAndOrders",value ={
            @Result(id = true,column = "id", property = "id"),
            @Result(id = false, column = "name", property = "name"),
            @Result(property = "orders",
                    column = "id",
                    many = @Many(
                            select = "com.offcn.mapper.OrdersMapper.findOrdersById",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    Customer findCustomerAndOrders(Integer id);
}
