package com.jose.curso.springboot.app.aop.springboot_aop.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jose.curso.springboot.app.aop.springboot_aop.services.GreetingService;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping; 

@RequestMapping("/app")
@RestController
public class GreetingController {

    @Autowired
    private GreetingService greeting ; 



    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {

        return ResponseEntity.ok( Collections.singletonMap("greeting" , greeting.sayHello("jose", "hola que tal")));
    }
    

    @GetMapping("/greetingError")
    public ResponseEntity<?> greetingError() {

        return ResponseEntity.ok( Collections.singletonMap("greeting" , greeting.sayHelloError("jose", "hola que tal")));
    }
    
}
