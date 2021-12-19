package com.sachishin.comprente.Controller;

import com.sachishin.comprente.Service.UserService;
import com.sachishin.comprente.DTO.AuthRequest;
import com.sachishin.comprente.DTO.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(AuthRequest authRequest){

        return "Logged in";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String Register(@Valid @RequestBody RegisterRequest registerRequest){
        var result = userService.CreateUser(registerRequest);
        if(result==null){
            return null;
        }else{
            return "Success";
        }
    }
}


