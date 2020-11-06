package com.offcn.dao.impl;

import com.offcn.dao.AccountDao;
import com.offcn.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl  implements AccountDao {

    private JdbcTemplate jdbcTemplate;
    @Override
    public Account findAccount(Integer id) {
        try {
            Account account = jdbcTemplate.queryForObject("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), id);
            return account;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateAccount(Account account) {
        try {
            jdbcTemplate.update("update account set money=? where id=?", account.getMoney(), account.getId());
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
