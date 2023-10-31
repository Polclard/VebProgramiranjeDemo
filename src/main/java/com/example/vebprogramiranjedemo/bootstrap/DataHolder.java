package com.example.vebprogramiranjedemo.bootstrap;

import com.example.vebprogramiranjedemo.model.Category;
import javax.annotation.PostConstruct;

import com.example.vebprogramiranjedemo.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Category> categoryList = new ArrayList<Category>();
    public static List<User> userList = new ArrayList<>();
    @PostConstruct
    public void init()
    {
        categoryList.add(new Category("Software", "Software Category!!!"));
        categoryList.add(new Category("Books", "Books Category!!!"));

        userList.add(new User("john.doe", "john123*", "John", "Doe"));
        userList.add(new User("jane.goe", "jane123*", "Jane", "Goe"));
    }

}
