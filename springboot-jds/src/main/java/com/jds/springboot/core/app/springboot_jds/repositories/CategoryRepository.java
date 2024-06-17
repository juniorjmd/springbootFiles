package com.jds.springboot.core.app.springboot_jds.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jds.springboot.core.app.springboot_jds.entities.Category; 

public interface CategoryRepository extends CrudRepository<Category , Long>{

}
