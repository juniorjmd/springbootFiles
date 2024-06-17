package com.jose.curso.springboot.app.springboot_crud.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jose.curso.springboot.app.springboot_crud.interfaces.IUserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext; 

@Component
public class ExistsByUserNameValidation implements ConstraintValidator<ExistsByUsername,String> {

    @Autowired
    private IUserService userService ; 
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) { 
        if (userService != null){
        return !this.userService.existsByUsername(value);
        }
        return true;
    }
    
}
