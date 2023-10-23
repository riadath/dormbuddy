package com.dormbuddy.auth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserServices userServices;
    //constructor


    @GetMapping("all")
    public Optional<List<User>> getAllUsers(){
        return userServices.getAllUsers();
    }

}
