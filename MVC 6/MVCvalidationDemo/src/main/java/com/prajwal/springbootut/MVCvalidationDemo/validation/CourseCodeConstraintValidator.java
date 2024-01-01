package com.prajwal.springbootut.MVCvalidationDemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private  String coursePrefix;
    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix=constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        if(theCode==null)return false;

        boolean isValid = theCode.startsWith(coursePrefix);

        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Code must start with " + coursePrefix).addConstraintViolation();
        }

        return isValid;


    }
}
