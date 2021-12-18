package com.sachishin.comprente.Web.controller;

import com.sachishin.comprente.Service.UserService;
import com.sachishin.comprente.Web.dto.AuthRequest;
import com.sachishin.comprente.Web.dto.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/authController")
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(AuthRequest authRequest){

        return "Logged in";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String Register(RegisterRequest registerRequest){

        return "Registered";
    }
}


