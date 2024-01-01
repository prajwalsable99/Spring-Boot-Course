package com.example.springboottut.DemoApp4.rest;


import com.example.springboottut.DemoApp4.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> StudentData;
    @PostConstruct
    public void loadData(){
        StudentData=new ArrayList<>();
        StudentData.add(new Student("Prajwal","Sable"));
        StudentData.add(new Student("Vedant","Kolhe"));
        StudentData.add(new Student("Atharva","Mohite"));

    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return StudentData;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){


  // is student id isvalid
    if(id<0 || id>=StudentData.size()){
        throw new StudentNotFoundException("Student Id not found :"+id);
    }


        return StudentData.get(id);




    }


//    //exception handler
//
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException){
//
//        StudentErrorResponse studentErrorResponse=new StudentErrorResponse();
//        studentErrorResponse.setMessage(studentNotFoundException.getMessage());
//        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//        studentErrorResponse.setTimestamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){
//
//        StudentErrorResponse studentErrorResponse=new StudentErrorResponse();
//        studentErrorResponse.setMessage(exception.getMessage());
//        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//        studentErrorResponse.setTimestamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(studentErrorResponse,HttpStatus.BAD_REQUEST);
//    }
}
