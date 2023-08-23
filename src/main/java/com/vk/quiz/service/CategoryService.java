package com.vk.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.quiz.dao.CategoryDao;
import com.vk.quiz.model.Category;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public List<Category> getAllCategory(){
        return categoryDao.findAll();
    }

    public Optional<Category> getCategoryById(String id) {
        return categoryDao.findById(id);
    }
    
    public List<Category> getCategoryByName(String category) {
        return categoryDao.findByName(category);
    }

    public Category addCategory(Category category){
       return categoryDao.save(category);
    }

    public Category updateCategory(Category category){
        return categoryDao.save(category);
    }

    public Category deleteCategory(Category category){
        category.setDeleted(true);
        return categoryDao.save(category);
    }
}
