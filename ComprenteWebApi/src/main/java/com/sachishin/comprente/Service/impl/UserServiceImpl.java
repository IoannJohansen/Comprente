package com.sachishin.comprente.Service.impl;

import com.sachishin.comprente.Repository.impl.UserRepository;
import com.sachishin.comprente.Repository.model.User;
import com.sachishin.comprente.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        User res = null;
        try {
            res =  userRepository.getById(id);
            res.getEmail();
        }catch (Exception ex){
            return null;
        }
        return res;
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        saveUser(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUser() {
        userRepository.deleteAll();
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public boolean isUserExist(User user) {
        return findByName(user.getName()) != null;
    }

}