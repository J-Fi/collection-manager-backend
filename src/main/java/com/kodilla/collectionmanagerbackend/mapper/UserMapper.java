package com.kodilla.collectionmanagerbackend.mapper;

import com.kodilla.collectionmanagerbackend.domain.User;
import com.kodilla.collectionmanagerbackend.domain.UserDto;
import com.kodilla.collectionmanagerbackend.domain.UserToFrontendDto;
import com.kodilla.collectionmanagerbackend.repository.UserRepository;
import com.kodilla.collectionmanagerbackend.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(UserDto userDto) {
        return new User(userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getBirthday(),
                userDto.getEmail(),
                userDto.getLogin(),
                userDto.getPassword());
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getFirstName(),
                user.getLastName(),
                user.getBirthday(),
                user.getEmail(),
                user.getLogin(),
                user.getPassword());
    }

    public UserToFrontendDto mapToUserToFrontendDto(User user) {
        return new UserToFrontendDto(user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthday(),
                user.getEmail(),
                user.getLogin(),
                user.getPassword());
    }
}
