package com.example.springboottut.DemoApp4.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

//exception handler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException){

        StudentErrorResponse studentErrorResponse=new StudentErrorResponse();
        studentErrorResponse.setMessage(studentNotFoundException.getMessage());
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){

        StudentErrorResponse studentErrorResponse=new StudentErrorResponse();
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse,HttpStatus.BAD_REQUEST);
    }

}
