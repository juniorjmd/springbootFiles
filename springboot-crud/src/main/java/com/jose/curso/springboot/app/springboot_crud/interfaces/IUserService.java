package com.jose.curso.springboot.app.springboot_crud.interfaces;

import java.util.List;

import com.jose.curso.springboot.app.springboot_crud.models.User;

public interface IUserService {

    List<User> findAll();
    
    User save (User user) ;  

    boolean existsByUsername(String username);
}
