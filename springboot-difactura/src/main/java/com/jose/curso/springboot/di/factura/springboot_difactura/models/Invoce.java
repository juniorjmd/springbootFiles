package com.jose.curso.springboot.di.factura.springboot_difactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
@Component
public class Invoce {

   @Autowired
   private Cliente cliente ;

   @Value("${invoice.description.office}")
   private String descripcion;

   @Autowired
   private List<Item> items;

public Cliente getCliente() {
    return cliente;
}
public void setCliente(Cliente cliente) {
    this.cliente = cliente;
}
public String getDescripcion() {
    return descripcion;
}
public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}
public List<Item> getItems() {
    return items;
}
public void setItems(List<Item> items) {
    this.items = items;
}
public int getTotal(){
    int total  =  items.stream()
                .map(item -> item.getImporte())
                .reduce(0,(sum,importe)->sum + importe);
    return total;
}

@PostConstruct
public void init(){
    System.out.println("creando el componente de la factura");
    cliente.setName(cliente.getName().concat(" de jesus"));
    descripcion = descripcion.concat(" del cliente: ").concat(cliente.getName()).concat(" ").concat(cliente.getLastname());
}

@PreDestroy
public void destroy(){
    System.out.println("Destruyendo el componente o bean factura");
}



}
