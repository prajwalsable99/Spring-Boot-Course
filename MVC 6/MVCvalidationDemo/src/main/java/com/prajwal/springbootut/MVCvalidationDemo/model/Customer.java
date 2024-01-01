package com.prajwal.springbootut.MVCvalidationDemo.model;


import com.prajwal.springbootut.MVCvalidationDemo.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {


    @NotEmpty(message = "first name should not be empty")
    @Size(min =1 ,max = 6,message = " max len=6 ans min=3 ")
    private String firstName;

    @NotEmpty(message = "last name should not be empty")
    @Size(min =1 ,max = 6,message = " max len=6 ans min=3 ")
    private String lastName;

    @NotNull(message = "cannot be empty")
    @Max(value = 10 ,message = "max items is 10")
    @Min(value = 1,message = "min items is 1")
    private  Integer items;


    @Pattern(regexp = "^[A-Z0-9]{5}",message = "length must be 5,only Capital letters and digits")
    private  String postalCode;

    @NotEmpty(message = "cannot be empty")
    @CourseCode
    private String courseCode;
    public  Customer(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
