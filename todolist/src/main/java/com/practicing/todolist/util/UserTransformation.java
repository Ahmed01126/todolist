package com.practicing.todolist.util;

import com.practicing.todolist.model.dto.UserDto;
import com.practicing.todolist.model.entity.User;

import java.util.UUID;

public class UserTransformation {

    public static UserDto transform(User user) {
        if (user == null) {
            return null;
        }
        return new UserDto(user.getName(), user.getEmail(), user.getPassword());
    }

    public static User transform(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
