package com.jose.curso.springboot.app.springboot_crud.controllers;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.curso.springboot.app.springboot_crud.interfaces.IUserService;
import com.jose.curso.springboot.app.springboot_crud.models.User;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 

@CrossOrigin(origins = "http://localhost:4200" , originPatterns = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService  service;

    @GetMapping()
    public List<User> list() {
        return service.findAll();
    }
    
    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?>create(@Valid @RequestBody User user ,   BindingResult resutl){
        if(resutl.hasFieldErrors()){return Validation(resutl);}
        return ResponseEntity.status(HttpStatus.CREATED).body( service.save(user));
    }

    @PostMapping("/register")
    public ResponseEntity<?>register(@Valid @RequestBody User user ,   BindingResult resutl){ 

        user.setAdmin(false);
        return create(user , resutl);
    }

    
    
  private ResponseEntity<?> Validation(BindingResult result) {
    Map <String , String> error = new HashMap<>();
    result.getFieldErrors().forEach(err -> {
        error.put( err.getField(), "el campo " + err.getField() + " " + err.getDefaultMessage());
    } );
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
}
    
}
