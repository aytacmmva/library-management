package com.a100.librarymanagement.service;

import com.a100.librarymanagement.dto.UserDto;
import com.a100.librarymanagement.entity.User;

import java.util.List;

public interface UserService {

    UserDto getById(Integer id);

    List<UserDto> getAll();

    void create(UserDto user);

    void update(Integer id, UserDto user);

    void deleteById(Integer id);

    List<User> searchByFullName(String fullName);

    User getByEmail(String email);

}