package com.jose.curso.springboot.app.springboot_crud.services;

import java.util.List;
import java.util.Optional; 
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jose.curso.springboot.app.springboot_crud.interfaces.IUserRepository;
import com.jose.curso.springboot.app.springboot_crud.models.User;

@Service
public class JpaUserDetailsServices implements UserDetailsService {
    
    @Autowired
    private IUserRepository userRepository ; 

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
      Optional<User> userOpt =   userRepository.findByUsername(username);

      if(!userOpt.isPresent()){
        throw new UsernameNotFoundException(String.format("Username %s not existe en el sistema", username)) ;
      }
      User user = userOpt.orElseThrow();

      List<GrantedAuthority> authorities = user.getRoles()
      .stream()
      .map(role -> new SimpleGrantedAuthority(role.getName())).
      collect(Collectors.toList());
      

      return new org.springframework.security.core.userdetails
      .User(user.getUsername() ,user.getPassword() , user.isEnabled(),true,true,true
       , authorities      );
        
    }
    
}
