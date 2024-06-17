package com.jose.curso.springboot.calendar.interceptor.springboot_calendario.controllers;
 
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping; 


@RestController
@RequestMapping("/app")

public class AppController {

    @GetMapping("/foo")
    public ResponseEntity<?> foo(HttpServletRequest request){
        Map<String,Object> data = new HashMap<>();
        data.put( "title" , "Bienvenidos al sistema de atencion !!!" );
        data.put( "time" , new Date());
        data.put( "time" , request.getAttribute("message")); 
        return ResponseEntity.ok(data);
    }
}