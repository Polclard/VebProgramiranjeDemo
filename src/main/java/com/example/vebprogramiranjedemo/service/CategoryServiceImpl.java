package com.example.vebprogramiranjedemo.service;

import com.example.vebprogramiranjedemo.model.Category;
import com.example.vebprogramiranjedemo.repository.InMemoryCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final InMemoryCategoryRepository categoryRepository;

    public CategoryServiceImpl(InMemoryCategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(String name, String description) {
        if(name == null || name.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        Category newCategory = new Category(name, description);
        categoryRepository.save(newCategory);
        return newCategory;
    }

    @Override
    public Category update(String name, String description) {
        if(name == null || name.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        Category newCategory = new Category(name, description);
        categoryRepository.save(newCategory);
        return newCategory;
    }

    @Override
    public void delete(String name) {
        if(name == null || name.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        categoryRepository.delete(name);
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> searchCategories(String searchText) {
        return categoryRepository.search(searchText);
    }
}
