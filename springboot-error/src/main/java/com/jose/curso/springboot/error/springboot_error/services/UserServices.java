package com.jose.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import com.jose.curso.springboot.error.springboot_error.models.domain.User;

public interface UserServices {
    List<User> findAll();
    Optional<User> findById(Long id);
}
