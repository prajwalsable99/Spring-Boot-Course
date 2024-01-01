package com.prajwal.springboottut.AOPdemo4.dao;

import com.prajwal.springboottut.AOPdemo4.Account;

public interface AccountDAO {

    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account,boolean vip);
    int addFakeAccount();


}
