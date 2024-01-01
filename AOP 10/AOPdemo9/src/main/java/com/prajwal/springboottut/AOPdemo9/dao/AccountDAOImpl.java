package com.prajwal.springboottut.AOPdemo9.dao;

import com.prajwal.springboottut.AOPdemo9.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Account> findAll() {

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("[calling findAll() ]");

        Account a1=new Account("prajwal","level1");
        Account a2=new Account("yash","level2");
        Account a3=new Account("ashish","level3");

        List<Account> list=new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        System.out.println("service provide this data");
        for(Account account:list){
            System.out.println(account);
        }

        System.out.println("[ending findAll() ]");
        System.out.println("------------------------------------------------------------------------------------------");

        return list;
    }

    @Override
    public List<Account> findAll(boolean flag) {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("[calling findAll() ]");
        if(flag){


            Account a1=new Account("prajwal","level1");
            Account a2=new Account("yash","level2");
            Account a3=new Account("ashish","level3");

            List<Account> list=new ArrayList<>();
            list.add(a1);
            list.add(a2);
            list.add(a3);
            System.out.println("service provide this data");
            for(Account account:list){
                System.out.println(account);
            }

            System.out.println("[ending findAll() ]");
            System.out.println("------------------------------------------------------------------------------------------");

            return list;
        }
        else {
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("[about to end findAll() ]");

        throw new RuntimeException("Exception ocurred sorry,cant find accounts");
        }

    }


}
