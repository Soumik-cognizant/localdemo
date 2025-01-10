package com.cts.examportal.service;



import java.util.Set;

import com.cts.examportal.model.exam.Category;

public interface CategoryService {
    public Category addCategory(Category category);

    public Category updateCategory(Long id,Category category);

    public Set<Category> getCategories();

    public Category getCategory(Long categoryId);

    public void deleteCategory(Long categoryId);
}
