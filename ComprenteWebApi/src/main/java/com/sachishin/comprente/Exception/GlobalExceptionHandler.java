package com.sachishin.comprente.Exception;

import com.sachishin.comprente.DTO.AuthResponse;
import com.sachishin.comprente.DTO.RegisterResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<?> DuplicateUserHandler(HttpServletResponse res){
        log.error("Duplicate user exception");
        var regRes = new RegisterResponse();
        regRes.setSuccess(false);
        return new ResponseEntity<RegisterResponse>(regRes, HttpStatus.OK);
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<?> AuthExceptionHandler(HttpServletResponse res){
        var authResponse = new AuthResponse();
        authResponse.setSuccess(false);
        log.error("Auth exception");
        return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);
    }
}