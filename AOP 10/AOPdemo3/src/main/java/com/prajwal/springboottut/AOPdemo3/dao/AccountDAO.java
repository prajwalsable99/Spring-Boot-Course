package com.prajwal.springboottut.AOPdemo3.dao;

import com.prajwal.springboottut.AOPdemo3.Account;

public interface AccountDAO {

    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account,boolean vip);
    int addFakeAccount();


}
