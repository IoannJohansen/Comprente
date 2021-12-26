package com.comprent;

import com.sachishin.comprente.ComprentApplication;
import com.sachishin.comprente.DTO.RegisterRequest;
import com.sachishin.comprente.Exception.DuplicateUserException;
import com.sachishin.comprente.Repository.UserRepository;
import com.sachishin.comprente.Repository.model.User;
import com.sachishin.comprente.Service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ComprentApplication.class)
public class ModularTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @Test
    @Transactional
    public void testFindByUsername(){
        var user = new User();
        user.setUsername("TESTE");
        user.setRole("USER");
        user.setHashPassword("QWERTYUIOPQWEQWEQWEQWEQEWDFSDFSDFASDASDASDASDASD");
        user.setEmail("TEST@MAIL.COM");
        userRepository.save(user);
        var userByName = userRepository.findByUsername("TESTE");
        Assert.assertNotNull(userByName);
    }

    @Test
    @Transactional
    public void testCreateUser() throws DuplicateUserException {
        var registerDto = new RegisterRequest();
        registerDto.setEmail("johnydoe@mail.com");
        registerDto.setLogin("johnydoe@mail.com");
        registerDto.setPassword("JohnyDoe123123123");
        var res = userService.CreateUser(registerDto);
        Assert.assertNotNull(res);
    }

    @Test
    @Transactional
    public void testSetDefaultRole() throws DuplicateUserException {
        var registerDto = new RegisterRequest();
        registerDto.setEmail("johnydoe@mail.com");
        registerDto.setLogin("johnydoe@mail.com");
        registerDto.setPassword("JohnyDoe123123123");
        var res = userService.CreateUser(registerDto);
        Assert.assertEquals(res.getRole(), "USER");
    }

    @Test(expected = DuplicateUserException.class)
    @Transactional
    public void testUserDuplication() throws DuplicateUserException {
        var registerDto = new RegisterRequest();
        registerDto.setEmail("johnydoe@mail.com");
        registerDto.setLogin("johnydoe@mail.com");
        registerDto.setPassword("JohnyDoe123123123");
        userService.CreateUser(registerDto);
        userService.CreateUser(registerDto);
    }
}
