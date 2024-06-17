package com.jose.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.jose.springboot.di.app.springboot_di.models.Product;
import com.jose.springboot.di.app.springboot_di.repositories.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{ 
    private ProductRepository repostory ; 
    private Environment env;
   // public ProductServiceImpl(@Qualifier("productList") ProductRepository repostory , Environment env) {
    public ProductServiceImpl(@Qualifier("productJson" ) ProductRepository repostory , Environment env) {
        this.repostory = repostory;
        this.env = env;
    }
    
    public List<Product> findAll(){
       
       
        return repostory.findAll().stream().map(p->{
            Double priceImp = p.getPrice() *  env.getProperty("config.price.tax" , Double.class);  
           // p.setPrice(priceImp.longValue());
           // return p;
           //   Product newProd = new Product(p.getId(), p.getName(), priceImp.longValue());
          Product newProd = (Product) p.clone();
          newProd.setPrice(priceImp.longValue());
           return newProd;
        }).collect(Collectors.toList());
    }
    public Product findById(Long id){

        return repostory.findById(id);
    }
}
