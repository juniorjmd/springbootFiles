package com.jose.curso.springboot.app.springboot_crud.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.jose.curso.springboot.app.springboot_crud.models.Product;
import com.jose.curso.springboot.app.springboot_crud.services.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@CrossOrigin(origins = "http://localhost:4200" , originPatterns = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service ;

    @GetMapping()
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Product> list() {
        return service.findAll();
    }
    

    
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<?> view(@PathVariable Long id) {
         Optional<Product> productOpc =  service.findById(id);
         if (productOpc.isPresent()){
            return ResponseEntity.ok(productOpc.orElseThrow());
         }
         return ResponseEntity.notFound().build();
    }


    @PostMapping  
    @PreAuthorize("hasRole('ADMIN')")  
    public ResponseEntity<?> create(@Valid @RequestBody Product prd ,  BindingResult resutl  ) {
      //  Product product = service.save(prd);         
      if(resutl.hasFieldErrors()){return Validation(resutl);}
    
       return ResponseEntity.status(HttpStatus.CREATED).body( service.save(prd));
   }

   @PutMapping("/{id}")  
   @PreAuthorize("hasRole('ADMIN')") 
   public ResponseEntity<?> update(@Valid @RequestBody Product prd , BindingResult resutl ,  @PathVariable Long id   ) { 
      if(resutl.hasFieldErrors()){return Validation(resutl);}
      Optional<Product> productOpc =  service.update(id , prd);
      if (productOpc.isPresent()){ 
         return ResponseEntity.ok(productOpc.orElseThrow());
      }
      return ResponseEntity.notFound().build();
  }





@DeleteMapping("/{id}")
@PreAuthorize("hasRole('ADMIN')") 
  public ResponseEntity<?> delete(@PathVariable Long id) { 
     Optional<Product> productOpc =  service.delete(id);
       if (productOpc.isPresent()){ 
          return ResponseEntity.ok(productOpc.orElseThrow());
       }
       return ResponseEntity.notFound().build();
  }



  private ResponseEntity<?> Validation(BindingResult result) {
    Map <String , String> error = new HashMap<>();
    result.getFieldErrors().forEach(err -> {
        error.put( err.getField(), "el campo " + err.getField() + " " + err.getDefaultMessage());
    } );
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
}
}
