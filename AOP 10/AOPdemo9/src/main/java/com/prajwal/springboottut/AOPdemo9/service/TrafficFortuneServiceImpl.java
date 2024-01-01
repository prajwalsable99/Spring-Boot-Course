package com.prajwal.springboottut.AOPdemo9.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements  TrafficFortuneService{
    @Override
    public String getFortune() {


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Expect heavy traffic";
    }

    @Override
    public String getFortune(boolean flag) {
        if(flag)return this.getFortune();

        else {
            throw  new RuntimeException(" Some PROBLEM Occured ....");
        }
    }
}
