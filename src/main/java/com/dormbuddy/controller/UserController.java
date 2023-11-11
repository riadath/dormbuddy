package com.dormbuddy.controller;


import com.dormbuddy.entity.User;
import com.dormbuddy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("signup")
    public ResponseEntity<?> signup(
            @RequestBody User user
            ) {
        return ResponseEntity.ok(userService.signup(user));
    }

    @PostMapping("login")
    public ResponseEntity<?> login(
            @RequestBody User user
            ) {
        return ResponseEntity.ok(userService.login(user));
    }

}
