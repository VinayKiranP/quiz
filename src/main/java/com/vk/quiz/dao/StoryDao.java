package com.vk.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vk.quiz.model.Story;

@Repository
public interface StoryDao extends JpaRepository<Story, String> {
    
    List<Story> findByName(String name);
}
