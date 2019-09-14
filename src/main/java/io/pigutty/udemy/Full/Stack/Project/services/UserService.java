package io.pigutty.udemy.Full.Stack.Project.services;

import io.pigutty.udemy.Full.Stack.Project.domain.User;
import io.pigutty.udemy.Full.Stack.Project.exceptions.UsernameAlreadyExistsException;
import io.pigutty.udemy.Full.Stack.Project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser (User newUser){
        try{
            newUser.setPassword(bCryptPasswordEncoder.encode((newUser.getPassword())));
            newUser.setUsername(newUser.getUsername());
            return userRepository.save(newUser);
        }
        catch(Exception e){
            throw new UsernameAlreadyExistsException("Usernme '"+newUser.getUsername()+"' already exist");
        }
    }
}
