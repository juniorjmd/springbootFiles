package com.jose.curso.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceimpl implements GreetingService {

    @Override
    public String sayHello(String person, String phrase) { 
        String greeting =  phrase + " "+ person;
        System.out.println(greeting);
        return greeting;
    }

    @Override
    public String sayHelloError(String person, String phrase) {
        throw new RuntimeException("algun mensaje de error");
    }
    
}
