package com.offcn.dao;

import com.offcn.pojo.Account;

public interface AccountDao {
    /**
     * 查询
     */
    Account findAccount(Integer id);
    /**
     * 修改
     */
    void updateAccount(Account account);
}
