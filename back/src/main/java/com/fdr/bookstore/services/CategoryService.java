package com.fdr.bookstore.services;

import com.fdr.bookstore.entities.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategoryById(Long id);
    void deleteCategory(Category category);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
}
