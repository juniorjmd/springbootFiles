package com.jose.curso.springboot.app.springboot_crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jose.curso.springboot.app.springboot_crud.interfaces.IRoleRepository;
import com.jose.curso.springboot.app.springboot_crud.interfaces.IUserRepository;
import com.jose.curso.springboot.app.springboot_crud.interfaces.IUserService;
import com.jose.curso.springboot.app.springboot_crud.models.Role;
import com.jose.curso.springboot.app.springboot_crud.models.User;
 

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository ; 
    @Autowired
    private IRoleRepository repositoryRole ; 
    @Autowired
    private PasswordEncoder passwordEncoder; 

    @Transactional
    @Override
    public List<User> findAll() { 
        return (List<User>) repository.findAll();
    }

    
    @Transactional
    @Override
    public User save(User user) { 
        Optional<Role> opcRoleUser = repositoryRole.findByName("ROLE_USER"); 

        List<Role> roles = new ArrayList<>();
        opcRoleUser.ifPresent(roles::add);
        if(user.isAdmin()){
            Optional<Role> optRoleAdm = repositoryRole.findByName("ROLE_ADMIN"); 
            optRoleAdm.ifPresent(roles::add);
        }
        user.setRoles(roles); 
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }


    @Override
    public boolean existsByUsername(String username) { 
        return repository.existsByUsername(username);
    }
       
}
