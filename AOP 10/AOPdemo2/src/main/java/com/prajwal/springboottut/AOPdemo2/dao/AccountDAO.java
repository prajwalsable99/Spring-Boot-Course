package com.prajwal.springboottut.AOPdemo2.dao;

import com.prajwal.springboottut.AOPdemo2.Account;

public interface AccountDAO {

    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account,boolean vip);
    int addFakeAccount();

     String getAccName() ;

     void setAccName(String accName) ;

     String getAccCode() ;
     void setAccCode(String accCode) ;
}
