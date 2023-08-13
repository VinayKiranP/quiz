package com.vk.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vk.quiz.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    
    List<Question> findByCategory(String category);


    @Query(value="SELECT * FROM question q Where q.category =:category ORDER BY RAND() LIMIT :numQ", nativeQuery=true)
    List<Question> getRandomQuestionsByCategory(String category, Integer numQ);
}
