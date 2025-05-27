package com.data.repository;

import com.data.dto.CategoryDTO;
import com.data.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    List<Category> findCategoryByName(String name);
    boolean addCategory(CategoryDTO category);
    boolean updateCategory(CategoryDTO category);
    boolean deleteCategory(int id);
    Category findCategoryById(int id);
}
