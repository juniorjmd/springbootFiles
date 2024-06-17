package com.jose.curso.springboot.di.factura.springboot_difactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.jose.curso.springboot.di.factura.springboot_difactura.models.Item;
import com.jose.curso.springboot.di.factura.springboot_difactura.models.Product;

@Configuration
@PropertySources({
    @PropertySource(value = "classpath:data.properties" , encoding = "UTF-8" )
})
public class appConfig {
    @Bean
    @Primary
    List<Item> itemsInvoice(){
        Product p1 = new Product("Camara Sony" , 800);
        Product p2 = new Product("Biciclete Bianchi 26" , 100); 

        return Arrays.asList(new Item(p1,2) , new Item(p2,4)) ;
 
    }
    @Bean
    List<Item> itemsInvoiceOffice(){
        Product p1 = new Product("Monitor asus 24" , 500);
        Product p2 = new Product("notebook Razer" , 2400); 
        Product p3 = new Product("Impresora HP" , 800); 
        Product p4 = new Product("escritorio de oficina" , 900); 

        return Arrays.asList(new Item(p1,2) , new Item(p2,4),new Item(p3,2) , new Item(p4,7)) ;
 
    }
}
