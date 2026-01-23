package com.a100.librarymanagement.mapper;

import com.a100.librarymanagement.dto.UserDto;
import com.a100.librarymanagement.entity.User;

public class UserMapper {

    public static UserDto usertoUserDto(User user) {
        UserDto userdto = new UserDto();
        userdto.setUsername(user.getUsername());
        userdto.setEmail(user.getEmail());
        userdto.setPassword(user.getPassword());
        userdto.setRole(user.getRole());
        return userdto;
    }

    public static User userDtoToUser(UserDto userdto) {
        User user = new User();
        user.setUsername(userdto.getUsername());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setRole(userdto.getRole());
        return user;
    }
}