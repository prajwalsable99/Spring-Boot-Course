package com.prajwal.springboottut.AOPdemo7.dao;

import com.prajwal.springboottut.AOPdemo7.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account,boolean vip);
    int addFakeAccount();

    List<Account> findAll();
    List<Account> findAll(boolean flag);


}
