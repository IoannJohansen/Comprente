package com.sachishin.comprente.Service;

import com.sachishin.comprente.DTO.AuthRequest;
import com.sachishin.comprente.Exception.AuthException;
import com.sachishin.comprente.Exception.DuplicateUserException;
import com.sachishin.comprente.Repository.model.User;
import com.sachishin.comprente.DTO.RegisterRequest;

public interface UserService {
    User findByUsername(String name);
    User CreateUser(RegisterRequest registerDto) throws DuplicateUserException;
    User Login(AuthRequest authDto) throws AuthException;
}
