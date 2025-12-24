package com.a100.librarymanagement.mapper;

import com.a100.librarymanagement.dto.BookDto;
import com.a100.librarymanagement.dto.UserDto;
import com.a100.librarymanagement.entity.User;

public class UserMapper {

    public static UserDto usertoUserDto(User user) {
        UserDto userdto = new UserDto();
        userdto.setFullName(user.getFullName());
        userdto.setEmail(user.getEmail());
        userdto.setPassword(user.getPassword());
        userdto.setRole(user.getRole());
        return userdto;
    }

    public static User userDtoToUser(UserDto userdto) {
    User user = new User();
    user.setFullName(userdto.getFullName());
    user.setEmail(userdto.getEmail());
    user.setPassword(userdto.getPassword());
    user.setRole(userdto.getRole());
    return user;
    }
}
