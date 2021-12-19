package com.sachishin.comprente.DTO;

public class AuthRequest {
    public String login;
    public String password;

    @Override
    public String toString() {
        return "AuthRequest{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
