package com.sachishin.comprente.Service.impl;

import com.sachishin.comprente.DTO.AuthRequest;
import com.sachishin.comprente.Exception.AuthException;
import com.sachishin.comprente.Exception.DuplicateUserException;
import com.sachishin.comprente.Repository.UserRepository;
import com.sachishin.comprente.Repository.model.User;
import com.sachishin.comprente.Service.UserService;
import com.sachishin.comprente.DTO.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public User CreateUser(RegisterRequest registerDto) {
        try{
            var user = userRepository.findByUsername(registerDto.getLogin());
            if(user!=null)throw new DuplicateUserException("Duplicate username");
            var newUser = new User();
            newUser.setUsername(registerDto.getLogin());
            newUser.setEmail(registerDto.getEmail());
            newUser.setRole("USER");
            newUser.setHashPassword(passwordEncoder.encode(registerDto.getPassword()));
            userRepository.save(newUser);
            return newUser;
        }catch(DuplicateUserException ex){
            return null;
        }
    }

    @Override
    public User Login(AuthRequest authDto) throws AuthException {
        var user = userRepository.findByUsername(authDto.getLogin());
        if(user==null)throw new AuthException();
        return user;
    }
}