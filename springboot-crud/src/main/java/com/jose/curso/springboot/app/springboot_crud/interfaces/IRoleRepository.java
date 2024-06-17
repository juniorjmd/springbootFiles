package com.jose.curso.springboot.app.springboot_crud.interfaces;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jose.curso.springboot.app.springboot_crud.models.Role;

public interface IRoleRepository extends CrudRepository <Role,Long> {
     Optional<Role> findByName(String name);
     
}
