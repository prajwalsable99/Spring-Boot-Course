package com.prajwal.springbootut.MVCvalidationDemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //default
    public String value() default "PCM";


    //message
    public String message() default "must start with PCM";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};





}
