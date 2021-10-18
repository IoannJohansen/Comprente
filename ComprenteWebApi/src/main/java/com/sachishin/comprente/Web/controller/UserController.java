package com.sachishin.comprente.Web.controller;

import com.sachishin.comprente.Repository.model.User;
import com.sachishin.comprente.Service.UserService;
import com.sachishin.comprente.validation.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/user/")
    public ResponseEntity<List<User>> listAllUser() {
        List<User> users = userService.findAllUser();
        if(users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        log.warn("Processing request");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        //Test validation
        DataBinder binder = new DataBinder(user);
        binder.setValidator(new UserValidator());
        binder.validate();
        BindingResult resVal = null;
        resVal = binder.getBindingResult();
        if(resVal.getAllErrors().size()!=0){
            log.warn(resVal.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //Test validation
        if (userService.isUserExist(user)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}