package com.prajwal.springboottut.AOPdemo2.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public void addAccount() {


            System.out.println("[Inside :" + this.getClass().getSimpleName() +" ]");
            System.out.println("[ADDING member ACCOUNT]");


    }
}
