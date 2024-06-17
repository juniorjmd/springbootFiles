package com.jds.springboot.core.app.springboot_jds.services;

import java.util.List;
import java.util.Optional;

import com.jds.springboot.core.app.springboot_jds.entities.Product;

public interface ProductService {
    
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Optional<Product> update(Long id , Product product);
    Optional<Product>  delete(Long id);
}
