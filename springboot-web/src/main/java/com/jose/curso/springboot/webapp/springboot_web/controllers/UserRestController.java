package com.jose.curso.springboot.webapp.springboot_web.controllers;

 
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.curso.springboot.webapp.springboot_web.models.User;
import com.jose.curso.springboot.webapp.springboot_web.models.dto.UserDto;
@RestController
public class UserRestController {

  @GetMapping("/api/details")
  public UserDto  details(){ 
    User user = new User("Jose" ,  "Dominguez" );
    UserDto userDto = new UserDto();

    userDto.setUser(user);
    userDto.setTitle( "hola mundo spring boot" ); 
    return userDto;
  }

  @GetMapping("/api/list")
public List<User> list(){
  User user = new User("Jose" ,  "Dominguez" );
  User user2 = new User("pepe" ,  "Dominguez" );
  User user3 = new User("Juan" ,  "Dominguez" );
  
  List<User> users = Arrays.asList(user,user2,user3);
  // List<User> users = new ArrayList<User>();
  //users.add(user);
 // users.add(user2);
 // users.add(user3);

  return users;
}

@GetMapping("/api/details-map")
  public Map<String,Object>  detailsMap(  ){ 
    User user = new User("Jose" ,  "Dominguez" );
    Map<String,Object> body = new HashMap<>();
    body.put("title",      "hola mundo spring boot" ); 
    body.put("user",      user); 
    return body;
  }


}
