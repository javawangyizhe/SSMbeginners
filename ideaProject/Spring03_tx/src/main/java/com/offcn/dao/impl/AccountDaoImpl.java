package com.offcn.dao.impl;

import com.offcn.dao.AccountDao;
import com.offcn.pojo.Account;
import com.offcn.utils.TxManager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AccountDaoImpl  implements AccountDao {
    private QueryRunner qr = new QueryRunner();
    //private Connection connection;
    //public AccountDaoImpl(Connection connection){
    //    this.connection=connection;
    //}

    @Override
    public Account findAccount(Integer id) {
        try {
            Account account = qr.query(TxManager.getConncetion(), "select * from account where id = ?", new BeanHandler<>(Account.class), id);
            return account;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateAccount(Account account) {
        try {
            qr.update(TxManager.getConncetion(), "update account set money=? where id=?", account.getMoney(), account.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
