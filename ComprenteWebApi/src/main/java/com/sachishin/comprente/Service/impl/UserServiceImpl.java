package com.sachishin.comprente.Service.impl;

import com.sachishin.comprente.Exception.DuplicateUserException;
import com.sachishin.comprente.Repository.UserRepository;
import com.sachishin.comprente.Repository.model.User;
import com.sachishin.comprente.Service.UserService;
import com.sachishin.comprente.DTO.RegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Override
    public User findByName(String name) {
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
            log.error("Duplicating username");
            return null;
        }
    }
}