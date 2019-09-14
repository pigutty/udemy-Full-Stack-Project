package io.pigutty.udemy.Full.Stack.Project.services;

import io.pigutty.udemy.Full.Stack.Project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    
}
