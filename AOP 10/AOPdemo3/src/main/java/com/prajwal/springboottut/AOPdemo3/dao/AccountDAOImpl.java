package com.prajwal.springboottut.AOPdemo3.dao;

import com.prajwal.springboottut.AOPdemo3.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements  AccountDAO{


    @Override
    public void addAccount() {

        System.out.println("[Inside :" + this.getClass().getSimpleName() +" ]");
        System.out.println("[ADDING  ACCOUNT]");

    }

    @Override
    public void addAccount(Account account) {

        System.out.println("[Inside :" + this.getClass().getSimpleName() +" ]");
        System.out.println("[ADDING REAL ACCOUNT]");
        System.out.println( "details:"+account.toString());
    }

    @Override
    public void addAccount(Account account, boolean vip) {
        System.out.println("[Inside :" + this.getClass().getSimpleName() +" ]");
        System.out.println("[ADDING VIP REAL ACCOUNT]");
        String x= vip==true?"YES":"NO";

        System.out.println( "details:"+account.toString()+"Is VIP :"+x);

    }

    @Override
    public int addFakeAccount() {
        System.out.println("[Inside :" + this.getClass().getSimpleName() +" ]");
        System.out.println("[ADDING FAKE ACCOUNT]");
        return -1;
    }


}
