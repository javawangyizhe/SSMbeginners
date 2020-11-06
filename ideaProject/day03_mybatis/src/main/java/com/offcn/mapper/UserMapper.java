package com.offcn.mapper;

import com.offcn.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * 根据id进行查找
     */
    User findUserById(Integer uid);

    /**
     * ；查找全部user
     */
    List<User> findAllUser();

    /**
     * 模糊查询
     */
    List<User> findUserByName(String uname);

    /**
     * 查询总条数
     */
    Integer findCount();

    /**
     * 增加
     */
    Integer insertUser(User user);

    /**
     * 修改
     */
    Integer updateUser(User user);

    /**
     * 删除
     */
    void deleteUserById(Integer uid);

}
