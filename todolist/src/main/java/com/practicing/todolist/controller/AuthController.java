package com.practicing.todolist.controller;

import com.practicing.todolist.model.dto.UserDto;
import com.practicing.todolist.model.entity.User;
import com.practicing.todolist.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@Valid @RequestBody UserDto userDto){
        return userService.registerUser(userDto);
    }

    @PostMapping("/login")
    public String loginUser(@Valid @RequestBody UserDto userDto) throws Exception {
        return userService.loginUser(userDto);
    }

}
