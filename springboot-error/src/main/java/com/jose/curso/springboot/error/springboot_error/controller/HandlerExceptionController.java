package com.jose.curso.springboot.error.springboot_error.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.jose.curso.springboot.error.springboot_error.models.Error;
import com.jose.curso.springboot.error.springboot_error.exceptions.UserNotFoundException; 
@RestControllerAdvice
public class HandlerExceptionController {


    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<Error> divisionByCero(Exception ex){
        Error e =  new Error();
        e.setDate(new Date());
        e.setError("Division por cero");
        e.setMessage(ex.getMessage());
        e.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        //return ResponseEntity.internalServerError().body(e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .body(e);
    }


    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException ex){
        Error e =  new Error();
        e.setDate(new Date());
        e.setError("No Handler Found Exception");
        e.setMessage(ex.getMessage());
        e.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value())
        .body(e);
    }
    
    @ExceptionHandler({NumberFormatException.class})
    public Map<String,String> numberFormatException(Exception ex){
        Map<String,String> error = new HashMap<>();
        error.put("date", new Date().toString() ) ;
        error.put("error","numero invalido o incorrecto, no tiene formato de digito!" ) ; 
        error.put("message", ex.getMessage()) ; 
        error.put("status" , HttpStatus.INTERNAL_SERVER_ERROR.value() + "");


        return error;
    }    
    @ExceptionHandler({NullPointerException.class , HttpMessageNotWritableException.class , UserNotFoundException.class})
    public Map<String,String> UserNotFoundException(Exception ex){
        Map<String,String> error = new HashMap<>();
        error.put("date", new Date().toString() ) ;
        error.put("error","El usuario o role no existe!" ) ; 
        error.put("message", ex.getMessage()) ; 
        error.put("status" , HttpStatus.INTERNAL_SERVER_ERROR.value() + "");


        return error;
    }

}
