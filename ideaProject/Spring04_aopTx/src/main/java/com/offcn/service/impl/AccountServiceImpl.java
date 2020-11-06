package com.offcn.service.impl;

import com.offcn.dao.AccountDao;
import com.offcn.pojo.Account;
import com.offcn.service.AccountService;

public class AccountServiceImpl  implements AccountService {

    private AccountDao accountDao;

    @Override
    public void transfer(Integer sourceId, Integer targetId, Double money) {
            Account accountS = accountDao.findAccount(1001);
            Account accountT = accountDao.findAccount(1003);

            accountS.setMoney(accountS.getMoney()-money);
            accountT.setMoney(accountT.getMoney()+money);

            accountDao.updateAccount(accountS);
            int i = 8/0;
            accountDao.updateAccount(accountT);

    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
