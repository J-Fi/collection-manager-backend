package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.Book;
import com.kodilla.collectionmanagerbackend.domain.BookDto;
import com.kodilla.collectionmanagerbackend.domain.User;
import com.kodilla.collectionmanagerbackend.domain.UserDto;
import com.kodilla.collectionmanagerbackend.mapper.UserMapper;
import com.kodilla.collectionmanagerbackend.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDbService userDbService;

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        return userMapper.mapToUserDto(userDbService.findById(userId));
    }

    @PostMapping("/")
    public User createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        System.out.println(user.toString());
        return userDbService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userDbService.deleteUser(id);
    }
}
