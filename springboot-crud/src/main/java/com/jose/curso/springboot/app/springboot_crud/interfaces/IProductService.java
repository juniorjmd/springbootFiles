package com.jose.curso.springboot.app.springboot_crud.interfaces;

import java.util.List;
import java.util.Optional;

import com.jose.curso.springboot.app.springboot_crud.models.Product;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Optional<Product> update(Long id , Product product);
    Optional<Product>  delete(Long id);
}
