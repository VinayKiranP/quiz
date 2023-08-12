package com.vk.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vk.quiz.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {
    
}
