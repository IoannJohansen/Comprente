package com.sachishin.comprente.Web.controller;

import com.sachishin.comprente.Repository.model.User;
import com.sachishin.comprente.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public String Login(String login, String password){

        return "Hello wrodl!";
    }

}


