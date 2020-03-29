package com.example.service.impl;

import com.example.dao.IAccountDao;
import com.example.dao.impl.AccountDaoImpl;
import com.example.factory.BeanFactory;
import com.example.service.IAccountService;

/**
 * @Author ryan.xu
 * @since 2020/3/29
 */
public class AccountServiceImpl implements IAccountService {
    //private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (AccountDaoImpl)BeanFactory.getBeans("accountDaoImpl");
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
