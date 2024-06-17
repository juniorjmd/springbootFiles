package com.jose.curso.springboot.app.springboot_crud.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.jose.curso.springboot.app.springboot_crud.models.User;
import java.util.Optional;


public interface IUserRepository extends CrudRepository< User , Long> {
    
    boolean existsByUsername(String username);
    Optional<User>  findByUsername(String username);
}
