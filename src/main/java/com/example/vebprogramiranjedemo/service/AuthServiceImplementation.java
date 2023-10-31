package com.example.vebprogramiranjedemo.service;

import com.example.vebprogramiranjedemo.model.User;
import com.example.vebprogramiranjedemo.model.exception.InvalidArgumentsException;
import com.example.vebprogramiranjedemo.model.exception.InvalidUserCredentialException;
import com.example.vebprogramiranjedemo.model.exception.PasswordNotMatchingException;
import com.example.vebprogramiranjedemo.repository.InMemoryUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImplementation implements AuthService{

    private final InMemoryUserRepository inMemoryUserRepository;

    public AuthServiceImplementation(InMemoryUserRepository inMemoryUserRepository)
    {
        this.inMemoryUserRepository = inMemoryUserRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username == null || username.isEmpty() || password==null || password.isEmpty())
        {
            throw new InvalidArgumentsException();
        }
        return inMemoryUserRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUserCredentialException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if(username == null ||
        username.isEmpty() ||
        password==null ||
        password.isEmpty() ||
        name == null ||
        name.isEmpty() ||
        surname == null ||
        surname.isEmpty())
        {
            throw new InvalidArgumentsException();
        }

        if(!password.equals(repeatPassword))
        {
            throw new PasswordNotMatchingException();
        }


        User user = new User(
                username,
                password,
                name,
                surname
                );

        inMemoryUserRepository.saveOrUpdate(user);
        return user;
    }
}
