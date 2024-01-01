package com.prajwal.springboottut.AOPdemo9.dao;

import com.prajwal.springboottut.AOPdemo9.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account,boolean vip);
    int addFakeAccount();

    List<Account> findAll();
    List<Account> findAll(boolean flag);


}
