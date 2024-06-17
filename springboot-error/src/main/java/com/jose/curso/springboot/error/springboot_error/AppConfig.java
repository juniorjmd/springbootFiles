package com.jose.curso.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jose.curso.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppConfig {
    

@Bean
List<User>  Users() { 
    
      List<User> users;
             users = new ArrayList<>();
            
            users.add( new User( 1L , "Pepe" , "Gonzalez") );
            users.add( new User( 2L , "andres" , "Gonzalez") );
            users.add( new User( 3L , "Pedro" , "Gonzalez") );
            users.add( new User( 4L , "maria" , "Gonzalez") );
            users.add( new User( 5L , "josefa" , "Gonzalez") );
            return users;
    }


}
