package com.practicing.todolist.service;

import com.practicing.todolist.model.dto.UserDto;
import com.practicing.todolist.model.entity.User;
import com.practicing.todolist.repository.UserRepository;
import com.practicing.todolist.util.UserTransformation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String registerUser(UserDto userDto) throws Exception {
        User user = UserTransformation.transform(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);
        return jwtService.generateToken(user.toString());
    }


}
