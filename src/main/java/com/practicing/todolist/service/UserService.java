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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    @Transactional
    public String registerUser(UserDto registrationDto) throws Exception {
        // Check if user already exists
        if (userRepository.existsByEmail(registrationDto.getEmail())) {
            throw new Exception("User with email already exists");
        }

        // Create new entity - don't set ID if using @GeneratedValue
        User user = new User();
        user.setName(registrationDto.getName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        // Don't set version - let Hibernate handle it
        // Don't set ID if using @GeneratedValue

        // Use save() for new entities - this will call persist()
        userRepository.save(user);
        return jwtService.generateToken(user.toString());
    }

//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtService = jwtService;
//    }
//
//    public String registerUser(UserDto userDto) throws Exception {
//        if (userRepository.existsByEmail(userDto.getEmail())) {
//            throw new Exception("User with email already exists");
//        }
//        User user = UserTransformation.transform(userDto);
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        if(user.getVersion() == null) {
//            user.setVersion(0L); // Initialize version if it's null
//        }
//        userRepository.save(user);
//        return jwtService.generateToken(user);
//    }


}
