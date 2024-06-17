package com.jose.curso.springboot.jpa.springboot_jpa_relationship.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jose.curso.springboot.jpa.springboot_jpa_relationship.entities.Client;


public interface ClientRepository extends CrudRepository<Client , Long>{
     
      @Query("select c from Client c join fetch c.addresses where c.id = ?1")
      Optional<Client> findOne( long id);
}
