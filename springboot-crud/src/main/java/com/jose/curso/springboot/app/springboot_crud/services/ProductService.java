package com.jose.curso.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jose.curso.springboot.app.springboot_crud.interfaces.IProductRepository;
import com.jose.curso.springboot.app.springboot_crud.interfaces.IProductService;
import com.jose.curso.springboot.app.springboot_crud.models.Product;
 

@Service
public class ProductService  implements IProductService{
    
    @Autowired
    IProductRepository repository ; 

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() { 
        return (List<Product>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) { 
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Product save(Product product) { 
        return repository.save(product);
    }

    @Override
    @Transactional
    public Optional<Product> update(Long id , Product product) { 
        Optional<Product>  prdOptional = repository.findById(id);
        if(prdOptional.isPresent()){
            Product productDb = prdOptional.orElseThrow();
            productDb.setName(product.getName());
            productDb.setPrice(product.getPrice());
            return Optional.of(  repository.save(productDb));
        }    
        return prdOptional;
    }


    @Override
    @Transactional
    public Optional<Product> delete(Long id) {
        Optional<Product>  prdOptional = repository.findById(id); 
        prdOptional.ifPresent( productDb -> {repository.delete(productDb);} ) ;  
        return prdOptional;
    }
 
   
   
    
}
