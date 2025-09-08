package com.rahul.quiz_service.controller;

import com.rahul.quiz_service.model.Users;
import com.rahul.quiz_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody Users user) {
        Users user1 = userService.addUser(user);
        return ResponseEntity.ok(user1);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
        return ResponseEntity.ok(userService.authenticateUser(user));
    }

}
