package com.example.ui;

import com.example.factory.BeanFactory;
import com.example.service.IAccountService;
import com.example.service.impl.AccountServiceImpl;

/**
 * @Author ryan.xu
 * @since 2020/3/29
 */
public class Client {
    public static void main(String[] args) {
        //IAccountService accountService = new AccountServiceImpl();
        IAccountService accountService = (IAccountService) BeanFactory.getBeans("accountServiceImpl");
        accountService.saveAccount();
    }
}
