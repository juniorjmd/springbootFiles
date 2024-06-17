package com.jds.springboot.core.app.springboot_jds.repositories; 

import org.springframework.data.repository.CrudRepository;

import com.jds.springboot.core.app.springboot_jds.entities.Product;

public interface ProductRepository extends CrudRepository<Product , Long>{

}
