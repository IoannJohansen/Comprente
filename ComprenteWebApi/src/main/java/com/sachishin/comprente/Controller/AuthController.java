package com.sachishin.comprente.Controller;

import com.sachishin.comprente.DTO.AuthRequest;
import com.sachishin.comprente.DTO.AuthResponse;
import com.sachishin.comprente.DTO.RegisterRequest;
import com.sachishin.comprente.DTO.RegisterResponse;
import com.sachishin.comprente.Exception.AuthException;
import com.sachishin.comprente.Exception.DuplicateUserException;
import com.sachishin.comprente.Security.jwt.JwtProvider;
import com.sachishin.comprente.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtProvider tokenProvider;

    @Autowired
    public AuthController(UserService userService, JwtProvider tokenProvider) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> Login(@Valid @RequestBody AuthRequest authRequest) throws AuthException {
        var authResponse = new AuthResponse();
          var user = userService.Login(authRequest);
          String userName = authRequest.getLogin();
          String token = tokenProvider.generateToken(userName, user.getId(), user.getRole());
          authResponse.setRole(user.getRole());
          authResponse.setToken(token);
          authResponse.setSuccess(true);
          authResponse.setUsername(authRequest.getLogin());
          authResponse.setUserId(user.getId());
          return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> Register(@Valid @RequestBody RegisterRequest registerRequest) throws DuplicateUserException {
        var result = userService.CreateUser(registerRequest);
        var response = new RegisterResponse();
        if(result!=null){
            response.setRole(result.getRole());
            response.setUsername(result.getUsername());
            response.setToken(tokenProvider.generateToken(result.getUsername(), result.getId(), "USER"));
            response.setSuccess(true);
            response.setUserId(result.getId());
        }else{
            response.setSuccess(false);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


