package com.example.springboottut.DemoApp4.entity;

public class Student {

    private String fisrtName;
    private String lastName;
    public Student(){

    }
    public Student(String fisrtName, String lastName) {
        this.fisrtName = fisrtName;
        this.lastName = lastName;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
