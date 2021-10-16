package com.sachishin.comprente.Service;

import com.sachishin.comprente.Repository.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findById(Long id);
    User findByName(String name);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
    void deleteAllUser();
    List<User> findAllUser();
    boolean isUserExist(User user);

}
