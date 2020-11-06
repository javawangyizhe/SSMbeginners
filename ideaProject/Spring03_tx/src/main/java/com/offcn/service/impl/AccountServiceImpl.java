package com.offcn.service.impl;

import com.offcn.dao.AccountDao;
import com.offcn.dao.impl.AccountDaoImpl;
import com.offcn.pojo.Account;
import com.offcn.service.AccountService;
import com.offcn.utils.TxManager;

public class AccountServiceImpl  implements AccountService {
    //private Connection connection = C3P0Tool.getConnection();
    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void transfer(Integer sourceId, Integer targetId, Double money) {

            TxManager.start();
            Account accountS = accountDao.findAccount(1001);
            Account accountT = accountDao.findAccount(1003);

            accountS.setMoney(accountS.getMoney()-money);
            accountT.setMoney(accountT.getMoney()+money);

            accountDao.updateAccount(accountS);
            accountDao.updateAccount(accountT);

    }
}
