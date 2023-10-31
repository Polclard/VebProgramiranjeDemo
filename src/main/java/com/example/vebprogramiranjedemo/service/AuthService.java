package com.example.vebprogramiranjedemo.service;

import com.example.vebprogramiranjedemo.model.User;

public interface AuthService {
    User login(String username, String password);
    User register(String username, String password, String repeatPassword, String name, String surname);
}
