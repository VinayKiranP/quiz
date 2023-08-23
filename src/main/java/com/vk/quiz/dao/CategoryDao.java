package com.vk.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vk.quiz.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, String> {
    
    List<Category> findByName(String category);
}
