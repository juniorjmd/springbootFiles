package com.jose.curso.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.List; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.jose.curso.springboot.webapp.springboot_web.models.User; 

@Controller
public class UserController {

@GetMapping("/details")
  public String details( Model model){ 
    
    User user = new User("Jose" ,  "Dominguez" );
    model.addAttribute("title",      "hola mundo spring boot" ); 
    model.addAttribute("user",     user ); 
    return "details";
  }



  @GetMapping("/list")
  public String getMethodName(ModelMap model) {
    User user = new User("Jose" ,  "Dominguez" , "juniorjmd@gmail.com" );
    User user2 = new User("pepe" ,  "Dominguez" , "juniorjmd@gmail.com");
    User user3 = new User("Juan" ,  "Dominguez"  );
    
    List<User> users = Arrays.asList(user,user2,user3);
    model.addAttribute("users", users);
    model.addAttribute("title","Listado de usuarios");
      return "list";
  }
  
}
