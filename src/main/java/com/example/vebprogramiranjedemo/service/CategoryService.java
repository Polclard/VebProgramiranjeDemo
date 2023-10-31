package com.example.vebprogramiranjedemo.service;

import com.example.vebprogramiranjedemo.bootstrap.DataHolder;
import com.example.vebprogramiranjedemo.model.Category;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface CategoryService {
    Category create(String name, String description);
    Category update(String name, String description);
    void delete(String name);
    List<Category> listCategories();
    List<Category> searchCategories(String searchText);
}
