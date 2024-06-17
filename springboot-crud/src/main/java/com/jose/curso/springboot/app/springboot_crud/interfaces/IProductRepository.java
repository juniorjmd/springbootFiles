package com.jose.curso.springboot.app.springboot_crud.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.jose.curso.springboot.app.springboot_crud.models.Product;

public interface IProductRepository  extends CrudRepository<Product,Long> {
    
}
