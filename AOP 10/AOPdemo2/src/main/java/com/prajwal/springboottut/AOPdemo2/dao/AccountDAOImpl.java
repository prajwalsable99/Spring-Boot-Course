package com.prajwal.springboottut.AOPdemo2.dao;

import com.prajwal.springboottut.AOPdemo2.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements  AccountDAO{

    private String accName;
    private String accCode;

    public String getAccName() {
        System.out.println("called: getAccName() ");
        return accName;
    }

    public void setAccName(String accName) {
        System.out.println("called: setAccName() ");
        this.accName = accName;
    }

    public String getAccCode() {
        System.out.println("called: getAccCode() ");
        return accCode;
    }

    public void setAccCode(String accCode) {
        System.out.println("called: setAccCode() ");
        this.accCode = accCode;
    }

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
