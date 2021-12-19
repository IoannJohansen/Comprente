package com.sachishin.comprente.Service;

import com.sachishin.comprente.Repository.model.User;
import com.sachishin.comprente.DTO.RegisterRequest;

public interface UserService {
    User findByName(String name);
    User CreateUser(RegisterRequest registerDto);
}
