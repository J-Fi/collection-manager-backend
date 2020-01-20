package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.*;
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

    @GetMapping("/email/{userEmail}")
    public UserToFrontendDto getUserByEmail(@PathVariable String userEmail) {
        return userMapper.mapToUserToFrontendDto(userDbService.findUserByEmail(userEmail));
    }


    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        return userMapper.mapToUserDto(userDbService.saveUser(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userDbService.deleteUser(id);
    }
}
