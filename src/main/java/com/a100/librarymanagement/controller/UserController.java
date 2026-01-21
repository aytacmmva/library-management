package com.a100.librarymanagement.controller;

import com.a100.librarymanagement.dto.UserDto;
import com.a100.librarymanagement.entity.User;
import com.a100.librarymanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/by-email")
    public User searchByEmail(@RequestParam String email) {
        return userService.getByEmail(email);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public void create(@RequestBody UserDto user) {
        userService.create(user);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody UserDto user) {
        userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteByiD(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}