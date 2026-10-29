package com.javarush.zimina.service;

import com.javarush.zimina.entity.User;
import com.javarush.zimina.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(String login, String password) {
        if(userRepository.findByLogin(login) != null) {
            return false;
        }
        User user = new User(null, login, password);
        userRepository.save(user);
        return true;
    }

    public User login(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
