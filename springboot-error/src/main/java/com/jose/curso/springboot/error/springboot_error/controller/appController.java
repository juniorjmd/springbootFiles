package com.jose.curso.springboot.error.springboot_error.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.jose.curso.springboot.error.springboot_error.models.domain.User;
import com.jose.curso.springboot.error.springboot_error.services.UserServices; 


@RequestMapping("/app")
@RestController
public class appController {
    @Autowired
   private UserServices service;
    @GetMapping()
    public String index()
    {  //int value = 600 / 0 ;
        int value = Integer.parseInt("hola") ;
        System.out.println(value);
        return "ok 200";
        }


    @GetMapping("/show/{id}")
    public User show(@PathVariable("id") Long id) {
        User user = service.findById(id).orElseThrow(()-> new UserNotFoundException("Error el usuario no existe!") );
        return user ;
    }
    
}
