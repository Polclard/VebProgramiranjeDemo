package com.example.vebprogramiranjedemo.repository;

import com.example.vebprogramiranjedemo.bootstrap.DataHolder;
import com.example.vebprogramiranjedemo.model.User;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Optional;

@Repository
public class InMemoryUserRepository {
    public Optional<User> findByUsername(String username)
    {
        return DataHolder.userList.stream().filter(r -> r.getUsername().equals(username)).findFirst();
    }

    public Optional<User> findByUsernameAndPassword(String username, String password)
    {
        return DataHolder.userList.stream().filter(r ->
                r.getUsername().equals(username)
                    &&
                r.getPassword().equals(password)
        ).findFirst();
    }

    public User saveOrUpdate(User user)
    {
        DataHolder.userList.removeIf(r ->
                r.getUsername().equals(user.getUsername()));
        DataHolder.userList.add(user);
        return user;
    }

    public void delete(String username)
    {
        DataHolder.userList.removeIf(r -> r.getUsername().equals(username));
    }


}
