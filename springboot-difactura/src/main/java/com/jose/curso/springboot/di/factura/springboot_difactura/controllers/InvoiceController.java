package com.jose.curso.springboot.di.factura.springboot_difactura.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jose.curso.springboot.di.factura.springboot_difactura.models.Invoce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/invoices") 
public class InvoiceController {
    @Autowired
    private Invoce invoce;

    @GetMapping("/show")
    public Invoce show(){
        return invoce;
    }
}
