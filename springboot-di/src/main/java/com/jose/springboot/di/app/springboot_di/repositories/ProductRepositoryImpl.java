package com.jose.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository; 
import com.jose.springboot.di.app.springboot_di.models.Product;
@Primary 
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> data;
    public ProductRepositoryImpl(){
        this.data = Arrays.asList(
            new Product(1L,"memoria corsair 32" , 300L) ,
            new Product(2L,"teclado genius" , 20L) ,
            new Product(3L,"fancooler procesador psi" , 120L) ,
            new Product(4L,"Motherboard Gigabyte" , 520L) 
        );
    }
    @Override
    public List<Product> findAll(){
        return this.data;
    }
    @Override
    public  Product  findById(Long id){
        return this.data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }
}
