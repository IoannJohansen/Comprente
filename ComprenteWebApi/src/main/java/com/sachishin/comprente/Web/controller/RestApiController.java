package com.sachishin.comprente.Web.controller;

import com.sachishin.comprente.Repository.model.User;
import com.sachishin.comprente.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/user/")
    public ResponseEntity<List<User>> listAllUser() {
        List<User> users = userService.findAllUser();
        if(users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
//        logger.info("Fetching User with id {}", id);
        User user = userService.findById(id);
        if (user == null) {
//            logger.error("User with id {} not found.", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
//        logger.info("Creating User : {}", user);
        System.out.println(user);
        if (userService.isUserExist(user)) {
//            logger.error("Unable to create. A User with name {} already exist", user.getName());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}
