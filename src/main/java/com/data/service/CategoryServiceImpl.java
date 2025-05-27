package com.data.service;

import com.data.dto.CategoryDTO;
import com.data.model.Category;
import com.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findCategoryByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

    @Override
    public boolean addCategory(CategoryDTO category) {
        return categoryRepository.addCategory(category);
    }

    @Override
    public boolean updateCategory(CategoryDTO category) {
        return categoryRepository.updateCategory(category);
    }

    @Override
    public boolean deleteCategory(int id) {
        return categoryRepository.deleteCategory(id);
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryRepository.findCategoryById(id);
    }
}
