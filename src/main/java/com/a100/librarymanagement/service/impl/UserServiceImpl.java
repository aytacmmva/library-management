package com.a100.librarymanagement.service.impl;

import com.a100.librarymanagement.dto.UserDto;
import com.a100.librarymanagement.entity.Book;
import com.a100.librarymanagement.entity.User;
import com.a100.librarymanagement.exception.EmailAlreadyExistsException;
import com.a100.librarymanagement.exception.UserNotFoundException;
import com.a100.librarymanagement.mapper.UserMapper;
import com.a100.librarymanagement.repository.BookRepository;
import com.a100.librarymanagement.repository.UserRepository;
import com.a100.librarymanagement.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

   UserRepository userRepository;

    @Override
    public UserDto getById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        return UserMapper.usertoUserDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(UserMapper::usertoUserDto).toList();
    }

    @Override
    public void create(UserDto userDto) {
        User user = UserMapper.userDtoToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public void update(Integer id, UserDto userDto) {
        User foundUser = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        foundUser.setFullName(userDto.getFullName());
        foundUser.setEmail(userDto.getEmail());
        foundUser.setPassword(userDto.getPassword());

        userRepository.save(foundUser);
    }

    @Override
    public void deleteById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        userRepository.delete(user);
    }

    @Override
    public List<User> searchByFullName(String fullName) {
        return userRepository.findByFullNameContainingIgnoreCase((fullName));
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()-> new EmailAlreadyExistsException(null));
    }
}
