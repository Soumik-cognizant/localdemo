package com.cts.examportal.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.examportal.model.exam.Category;
import com.cts.examportal.repository.CategoryRepository;
import com.cts.examportal.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

  

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());//give list that's why need for typecast
    }

    @Override
    public Category getCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = new Category();
        category.setCid(categoryId);
        this.categoryRepository.delete(category);
    }
    
    /*@Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }*/
    @Override
    public Category updateCategory(Long id,Category category) {
    	
    	Category localCategory=this.categoryRepository.findById(id).get();
    	
    	if(category.getTitle()!=null) {
    		localCategory.setTitle(category.getTitle());
    	}
    	if(category.getDescription()!=null) {
    		localCategory.setDescription(category.getDescription());
    	}
        return this.categoryRepository.save(localCategory);
    }
}
