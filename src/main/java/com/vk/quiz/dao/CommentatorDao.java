package com.vk.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vk.quiz.model.Commentator;

@Repository
public interface CommentatorDao extends JpaRepository<Commentator, String> {
    
}
