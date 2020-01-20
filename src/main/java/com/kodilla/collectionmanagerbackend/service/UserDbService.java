package com.kodilla.collectionmanagerbackend.service;

import com.kodilla.collectionmanagerbackend.domain.User;
import com.kodilla.collectionmanagerbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDbService {

    @Autowired
    private UserRepository userRepo;

    public User saveUser (User user) {
        return userRepo.save(user);
    }

    public void deleteUser(final Long id) {
        userRepo.deleteById(id);
    }

    public User findById(final Long id) {
        return userRepo.findById(id).orElse(new User());
    }

    public User findUserByEmail(String userEmail) {
        return userRepo.getUserByEmail(userEmail);
    }
}
