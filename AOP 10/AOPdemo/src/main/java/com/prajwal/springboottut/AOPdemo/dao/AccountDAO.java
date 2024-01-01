package com.prajwal.springboottut.AOPdemo.dao;

import com.prajwal.springboottut.AOPdemo.Account;

public interface AccountDAO {

    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account,boolean vip);
    int addFakeAccount();
}
